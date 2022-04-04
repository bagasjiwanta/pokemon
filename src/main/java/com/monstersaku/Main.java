package com.monstersaku;

import com.monstersaku.enums.ElementType;
import com.monstersaku.moves.DefaultMove;
import com.monstersaku.pools.EffectivityPool;
import com.monstersaku.pools.MonsterPool;
import com.monstersaku.util.CSVReader;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Main {

    private static final List<String> CSV_FILE_PATHS = Arrays.asList(
            "configs/monsterpool.csv",
            "configs/movepool.csv",
            "configs/element-type-effectivity-chart.csv");
    public static void main(String[] args) {
        EffectivityPool effectivityPool = EffectivityPool.getEffectivityPool();
        MonsterPool monsterPool = new MonsterPool(false);
        List<CSVReader> readers = new ArrayList<CSVReader>();
        CSVReader currentReader;

        for (String fileName : CSV_FILE_PATHS) {
            try {
                readers.add(new CSVReader(new File(Main.class.getResource(fileName).toURI()), ";"));
                // readers.add(new CSVReader(new File(Main.class.getResource(fileName).toURI()), ";"));
            } catch (Exception e) {
                // do nothing
            }
        }

        // read element type effectivity chart
        currentReader = readers.get(2);
        currentReader.setSkipHeader(true);
        try {
            List<String[]> lines = currentReader.read();
            for (String[] line : lines) {
                ElementType source, target;
                try {
                    source = ElementType.valueOf(line[0]);
                    target = ElementType.valueOf(line[1]);
                    double effectivity = Double.parseDouble(line[2]);
                    effectivityPool.add(source, target, effectivity);
                } catch (IllegalArgumentException e) {
                    System.out.println("[IllegalArgumentException] " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("[Exception] " + e.getMessage());
                }
            }
        } catch (Exception e) { }
        System.out.println(effectivityPool.getEffectivity(ElementType.FIRE, ElementType.WATER));
        System.out.println(effectivityPool.getEffectivity(ElementType.WATER, ElementType.FIRE));

        // read monster pool
        currentReader = readers.get(0);
        currentReader.setSkipHeader(true);
        try {
            List<String[]> lines = currentReader.read();
            for (String[] line : lines) {
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
                        Monster monster = new Monster(line[1], elementTypes, statsList, null);
                        monsterPool.add(monster);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }


                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (Exception e) { }

        // for (CSVReader reader : readers) {
        //     reader.setSkipHeader(true);
        //     try {
        //         List<String[]> lines = reader.read();
        //         for (String[] line : lines) {
        //             for (String word : line) {
        //                 System.out.printf("%s ", word);
        //             }
        //             System.out.println();
        //         }
        //         System.out.println();
        //     } catch (Exception e) {
        //         // do nothing
        //     }
        // }
    }
}
