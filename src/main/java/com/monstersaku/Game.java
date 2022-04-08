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
    }

    public void checkForWinner () {
        if (winner >= 0) {
            System.out.println("Selamat kepada " + currPName() + " telah memenangkan game ini");
            System.exit(1);
        }
    }

    public void calcAfter () {
        for (Monster monster : currMonsters().getMonsters()) {
            monster.afterEffect();
        }
        for (Monster monster : enemyMonsters().getMonsters()) {
            monster.afterEffect();
        }
    }

    public void loop () {
        while (true) {
            turn();
            turn();
            calcAfter();
            checkForWinner();
        }
    }

    public void turn () {
        System.out.println("Pilih gerakan");
        System.out.println("1. Move");
        System.out.println("2. Switch");
        int choice = Main.scanner.nextInt();

        if (choice == 1) {
            currMonsters().currMonster().displayMoves();
            choice = Main.scanner.nextInt();
            System.out.println(enemyMonsters().currMonster().getStats().getHealthPoint());
            currMonsters().currMonster().getMoveById(choice)
            .execute(
                currMonsters().currMonster(),
                enemyMonsters().currMonster()
            );
            System.out.println(enemyMonsters().currMonster().getStats().getHealthPoint());
            
        } else {
            currMonsters().printMonsters(currPName());
            System.out.println("Pilih pokemon untuk di switch");
            System.out.print("\n> ");
            choice = Main.scanner.nextInt();
            currMonsters().switchPokemon(choice);
        }
        changePlayer();
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
}
