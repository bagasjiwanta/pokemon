package com.monstersaku.pools;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.monstersaku.Monster;
import com.monstersaku.Stats;
import com.monstersaku.enums.ElementType;
import com.monstersaku.util.CSVReader;

public class MonsterPool {
    private List<Monster> monsterList;
    public static CSVReader reader;
    public static long randSeed = 1;
    private int currentMonster;

    // generate list of 6 random numbers
    private List<Integer> randSixInt(int max) {
        Random random = new Random(randSeed);
        MonsterPool.randSeed += 200;
        List<Integer> randomIntegers = new ArrayList<Integer>();
        for (int i = 0; i < 6; i++) {
            randomIntegers.add(random.nextInt(max + 1));
        }
        return randomIntegers;
    }

    public MonsterPool () {
        this.monsterList = new ArrayList<Monster>();
        currentMonster = 0;
    }

    public void printMonsters (String pname) {
        // klo ad yg mati di print
        System.out.println("\nMonster yang dimiliki : " + pname);
        for (int i = 0;i < 6;i++) {
            System.out.println(i + ". " + monsterList.get(i).getNama());
        }
    }

    public List<Monster> getMonsters() {
        return this.monsterList;
    }

    public void add (Monster monster) {
        if (this.monsterList.size() >= 6) {
            return;
        }
        this.monsterList.add(monster);
    }

    public static void setReader (CSVReader csvreader) {
        if (MonsterPool.reader == null) {
            MonsterPool.reader = csvreader;
        }
    }

    public Monster currMonster () {
        return this.monsterList.get(this.currentMonster);
    }

    public void setPokemon (int index) {
        // validasi dulu indexnya <=6 dan >=1
        // trus cek pokemonnya masih idup atau ga, klo udh mati, throw error aj atau print "pokemon dh mati"

        this.currentMonster = index;
    }

    public void readSixRandomMonster () {
        if (this.monsterList == null) {
            return;
        }
        this.monsterList.clear();
        reader.setSkipHeader(true);
        try {
            List<String[]> lines = reader.read();
            List<Integer> sixRandInt = randSixInt(lines.size() - 1);
            for (int i : sixRandInt) {
                String[] line = lines.get(i);
                try {
                    // read monster's element type
                    List<ElementType> elementTypes = new ArrayList<ElementType>();
                    for (String eltype : line[2].split(",")) {
                        try {
                            elementTypes.add(ElementType.valueOf(eltype));
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            break;
                        }
                    }
                    // read monster's stats
                    List<Double> statsList = new ArrayList<Double>();
                    for (String stat : line[3].split(",")) {
                        try {
                            statsList.add(Double.parseDouble(stat));
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            break;
                        }
                    }
                    Stats stats;
                    try {
                        // add monster to global monster pool
                        stats = new Stats(statsList);
                        List<Integer> moveIds = new ArrayList<Integer>();
                        
                        for (String moveid : line[4].split(",")) {
                            moveIds.add(Integer.parseInt(moveid));
                        }

                        Monster monster = new Monster(line[1], elementTypes, stats, moveIds);
                        this.add(monster);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }


                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        for (Monster monster : this.monsterList) {
            monster.readMoves();
        }
    }

    public int howManyAliveMonsters () {
        return 6;
    }

    public void switchPokemon (int index) {
        this.currentMonster = index - 1;
    }

    public void displayCurrMonster() {
        System.out.println("Nama            : " + this.currMonster().getNama());
        System.out.println("HP              : " + this.currMonster().getStats().getHealthPoint() + "/" + this.currMonster().getStats().getMaxHP());
        System.out.println("Attack          : " + this.currMonster().getStats().getAttack());
        System.out.println("Defense         : " + this.currMonster().getStats().getDefense());
        System.out.println("Special Attack  : " + this.currMonster().getStats().getSpecialAttack());
        System.out.println("Special Defense : " + this.currMonster().getStats().getSpecialDefense());
        System.out.println("Speed           : " + this.currMonster().getStats().getSpeed());
    }

    public void displayMonsters () {
        if (this.currMonster().isMonsterAlive()) {
            System.out.println("   Monster di field : " + this.currMonster().getNama() + " " + 
            this.currMonster().getStats().getHealthPoint() + "/" + this.currMonster().getStats().getMaxHP());
        } else {
            System.out.println("   Monster di field : " + this.currMonster().getNama() + " FAINTED");
        }
        System.out.println("   Monster di bag :");

        for (int i = 0; i < 6; i++) {
            String addition = "";
            if (!this.monsterList.get(i).isMonsterAlive()) {
                addition = "FAINTED";
            } else {
                addition = this.monsterList.get(i).getStats().getHealthPoint() + "/" + this.monsterList.get(i).getStats().getMaxHP();
            }
            if (i != currentMonster) {
                System.out.println("    - " + this.monsterList.get(i).getNama() + " " + addition);
            }
        }
    }
}
