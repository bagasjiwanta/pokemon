package com.monstersaku;
import com.monstersaku.pools.EffectivityPool;
import com.monstersaku.pools.MonsterPool;
import com.monstersaku.util.CSVReader;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    private static final List<String> CSV_FILE_PATHS = Arrays.asList(
            "configs/monsterpool.csv",
            "configs/movepool.csv",
            "configs/element-type-effectivity-chart.csv");
    public static void main(String[] args) {
        List<CSVReader> readers = new ArrayList<CSVReader>();

        for (String fileName : CSV_FILE_PATHS) {
            try {
                readers.add(new CSVReader(new File(Main.class.getResource(fileName).toURI()), ";"));
            } catch (Exception e) { }
        }
        MonsterPool.setReader(readers.get(0));
        Monster.setReader(readers.get(1));
        EffectivityPool.setReader(readers.get(2));
        
        EffectivityPool.readEffectivities();

        System.out.println("Pilih Command");
        System.out.println("1. Start Game");
        System.out.println("2. Help");
        System.out.println("3. Exit");
        System.out.print("> ");
        String input = Main.scanner.next();

        // minta input disini, tampilin help jg klo ada

        Game game = new Game("john", "doe");
        game.start();
        game.loop();
        // new game disini
        Main.scanner.close();
    }
}
