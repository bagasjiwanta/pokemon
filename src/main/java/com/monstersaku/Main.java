package com.monstersaku;

import com.monstersaku.util.CSVReader;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Main {

    private static final List<String> CSV_FILE_PATHS = Arrays.asList(
            "configs/monsterpool.csv",
            "configs/movepool.csv",
            "configs/element-type-effectivity-chart.csv");
    public static void main(String[] args) {
        EffectivityPool effectivityPool = new EffectivityPool();
        List<CSVReader> readers = new ArrayList<>();
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
                try {
                    effectivityPool.add(line[0], line[1], Double.parseDouble(line[2]));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (Exception e) { }
        System.out.println(effectivityPool.getEffectivity(ElementType.FIRE, ElementType.WATER));
        System.out.println(effectivityPool.getEffectivity(ElementType.FIRE, ElementType.NORMAL));

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
