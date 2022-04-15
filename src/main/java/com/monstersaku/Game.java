package com.monstersaku;

import java.util.ArrayList;
import java.util.List;

import com.monstersaku.pools.MonsterPool;

public class Game {
    private List<MonsterPool> monsterPools;
    private List<String> playerNames;
    private List<Integer> moves;
    private int whoseTurn;
    private int winner;
    private boolean change;

    public Game (String pname1, String pname2) {
        this.monsterPools = new ArrayList<MonsterPool>();
        this.monsterPools.add(new MonsterPool());
        this.monsterPools.add(new MonsterPool());

        this.playerNames = new ArrayList<String>();
        this.playerNames.add(pname1);
        this.playerNames.add(pname2);

        this.moves = new ArrayList<Integer>();

        whoseTurn = 0;
        winner = -1;
    }

    public String currPName () {
        return playerNames.get(whoseTurn);
    }

    public String enemyPName () {
        int x = 0;
        if (whoseTurn == 0) {
            x ++;
        }
        return playerNames.get(x);
    }

    public MonsterPool currMonsters () {
        return monsterPools.get(whoseTurn);
    }

    public MonsterPool enemyMonsters () {
        int who = 0;
        if (whoseTurn == 0) {
            who = 1;
        }
        return monsterPools.get(who);
    }

    public void start () {
        monsterPools.get(0).readSixRandomMonster();
        monsterPools.get(1).readSixRandomMonster();
        System.out.println("Selamat datang " + this.playerNames.get(0) + " dan " + this.playerNames.get(1));
    }

    public void checkForWinner () {
        if(enemyMonsters().howManyAliveMonsters() == 0) {
            System.out.println("Selamat kepada " + this.currPName() + " karena telah memenangkan game ini");
            System.exit(0);
        }

        if(currMonsters().howManyAliveMonsters() == 0) {
            System.out.println("Selamat kepada " + this.enemyPName() + " karena telah memenangkan game ini");
            System.exit(0);
        }
    }

    public void calcAfter () {
        if (whoseTurn == 0) {
            return;
        }
        System.out.println("\nMengecek kondisi monster-monster " + enemyPName());
        for (Monster monster : enemyMonsters().getMonsters()) {
            monster.afterEffect();
        }
        System.out.println("\nMengecek kondisi monster-monster " + currPName());
        for (Monster monster : currMonsters().getMonsters()) {
            monster.afterEffect();
        }
    }

    public void calcBefore () {
        for (Monster monster : currMonsters().getMonsters()) {
            monster.beforeEffect();
        }
    }

    public void execute () {
        int first = 0;
        int p1 = currMonsters().currMonster().getMoveById(moves.get(0)).getPriority();
        int p2 = enemyMonsters().currMonster().getMoveById(moves.get(1)).getPriority();
        if (p1 > p2) {
            first = 0;
        } else if (p1 < p2) {
            first = 1;
        } else if (p1 == p2) {
            double s1 = currMonsters().currMonster().getStats().getSpeed();
            double s2 = currMonsters().currMonster().getStats().getSpeed();
            if (s1 > s2) {
                first = 0;
            } else if (s1 < s2) {
                first = 1;
            }
        }

        int second = 0;
        if (first == 0) {
            second = 1;
        }
        this.monsterPools.get(first).currMonster().getMoveById(moves.get(first)).execute(
            this.monsterPools.get(first).currMonster(), 
            this.monsterPools.get(second).currMonster());

        this.monsterPools.get(second).currMonster().getMoveById(moves.get(second)).execute(
            this.monsterPools.get(second).currMonster(), 
            this.monsterPools.get(first).currMonster());
    }

    public void loop () {
        while (true) {
            calcBefore();
            turn();
            calcAfter();
            checkForWinner();
            changePlayer();
        }
    }

    public void turn () {
        String choice;
        // boolean exit = false;
        if (!currMonsters().currMonster().isMonsterAlive()){
            System.out.println(currMonsters().currMonster().getNama() + " sudah mati, ganti ke pokemon lain");
            choice = "2";
        } else {
        System.out.println("Pilih gerakanmu, " + this.currPName());
        System.out.println("[1] Move, [2] Switch, [3] View Monsters Info, [4] View Game Info");
        System.out.print("> ");
        choice = Main.scanner.next();}
        int input;
        switch (choice) {
            case "1" :
                currMonsters().currMonster().displayMoves();
                System.out.print("Pilih move yang akan dieksekusi\n> ");
                input = Main.scanner.nextInt();
                currMonsters().currMonster().getMoveById(input)
                .execute(
                    currMonsters().currMonster(),
                    enemyMonsters().currMonster()
                );
                change = true;
                break;
            case "2" : 
                boolean case2loop =true;
                while(case2loop){
                    currMonsters().printMonsters(currPName());
                System.out.println("Pilih pokemon untuk di switch");
                System.out.print("> ");
                input = Main.scanner.nextInt();
                if (input < 1 || input >6){
                    System.out.println("Invalid Input, silakan ulangi.");
                }else{
                    if (!currMonsters().currMonster().isMonsterAlive()){
                        if (currMonsters().switchPokemon(input) == true){
                            change = false;
                            case2loop=false;
                        }else{//Gagal melakukan switch karena pokemon mati:

                        }
                    }
                    else{
                        if (currMonsters().switchPokemon(input) == true){
                            change = true;
                            case2loop=false;
                        }else{
                            change=false;
                            case2loop=false;
                        }
                    }
                    
                }
                }

                
                
                break;
            case "3" : 
                viewMonstersInfo();
                change = false;
                break;
            case "4" :
                viewGameInfo();
                change = false;
                break;
            default:
                System.out.println("Input tidak valid");
                change = false;
                return;
            }
        
    }

    public void changePlayer () {
        if (change) {
            if (this.whoseTurn == 0) {
                this.whoseTurn ++;
            } else {
                this.whoseTurn --;
            }
        }
    }

    // function help disini
    public static void getHelp() {
        Help help = new Help();
        help.start();
    }   

    public void viewMonstersInfo () {
        System.out.println("Monster Info : ");
        this.monsterPools.get(whoseTurn).displayCurrMonster();;
    }

    public void viewGameInfo() { 
        System.out.println("Game Info : ");
        System.out.println("Giliran : " + this.currPName());
        System.out.println("Monster yang sedang bertarung : ");
        System.out.println("\nMonster yang dimiliki " + this.playerNames.get(0));
        this.monsterPools.get(0).displayMonsters();
        System.out.println("\nMonster yang dimiliki " + this.playerNames.get(1));
        this.monsterPools.get(1).displayMonsters();
        System.out.println();
    }
}
