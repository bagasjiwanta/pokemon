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
    private Boolean hasOwner;
    public static CSVReader reader;
    public static long randSeed = 1;

    // generate list of 6 random numbers
    private List<Integer> randSixInt(int max) {
        Random random = new Random(randSeed);
        randSeed ++;
        List<Integer> randomIntegers = new ArrayList<Integer>();
        for (int i = 0; i < 6; i++) {
            randomIntegers.add(random.nextInt(max + 1));
        }
        return randomIntegers;
    }

    public MonsterPool (Boolean hasOwner) {
        this.monsterList = new ArrayList<Monster>();
        this.hasOwner = hasOwner;
    }

    public void add (Monster monster) {
        if (this.hasOwner && this.monsterList.size() >= 6) {
            return;
        }
        this.monsterList.add(monster);
    }

    public Boolean hasOwner () {
        return this.hasOwner;
    }

    public static void setReader (CSVReader csvreader) {
        if (MonsterPool.reader == null) {
            MonsterPool.reader = csvreader;
        }
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
}
