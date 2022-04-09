package com.monstersaku;

import java.util.ArrayList;
import java.util.List;

import com.monstersaku.pools.MonsterPool;

public class Game {
    private List<MonsterPool> monsterPools;
    private List<String> playerNames;
    private int whoseTurn;
    private int winner;

    public Game (String pname1, String pname2) {
        this.monsterPools = new ArrayList<MonsterPool>();
        this.monsterPools.add(new MonsterPool());
        this.monsterPools.add(new MonsterPool());

        this.playerNames = new ArrayList<String>();
        this.playerNames.add(pname1);
        this.playerNames.add(pname2);

        whoseTurn = 0;
        winner = -1;
    }

    public String currPName () {
        return playerNames.get(whoseTurn);
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
        if (winner >= 0) {
            System.out.println("Selamat kepada " + currPName() + " telah memenangkan game ini");
            System.exit(1);
        }
    }

    public void calcAfter () {
        for (Monster monster : enemyMonsters().getMonsters()) {
            monster.afterEffect();
        }
    }

    public void calcBefore () {
        for (Monster monster : currMonsters().getMonsters()) {
            monster.beforeEffect();
        }
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
        System.out.println("Pilih gerakanmu, " + this.currPName());
        System.out.println("[1] Move, [2] Switch, [3] View Monsters Info, [4] View Game Info");
        System.out.print("> ");
        String choice = Main.scanner.next();
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
                break;
            case "2" : 
                currMonsters().printMonsters(currPName());
                System.out.println("Pilih pokemon untuk di switch");
                System.out.print("> ");
                input = Main.scanner.nextInt();
                currMonsters().switchPokemon(input);
                break;
            case "3" : 
                viewMonstersInfo();
                break;
            case "4" :
                viewGameInfo();
                break;
            default:
                System.out.println("Input tidak valid");
                return;
        }
    }

    public void changePlayer () {
        if (this.whoseTurn == 0) {
            this.whoseTurn ++;
        } else {
            this.whoseTurn --;
        }
    }

    // function help disini
    public static void getHelp() {
        System.out.println("HELP");
    }   

    public void viewMonstersInfo () {
        //
    }

    public void viewGameInfo() { 
        System.out.println("Game Info : ");
        System.out.println(" Giliran : " + this.currPName());
        System.out.println(" Monster yang sedang bertarung : ");
        System.out.println("  Monster yang dimiliki " + this.playerNames.get(0));
        this.monsterPools.get(0).displayMonsters();
        System.out.println("  Monster yang dimiliki " + this.playerNames.get(1));
        this.monsterPools.get(1).displayMonsters();
        System.out.println();
    }
}
