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
        List<CSVReader> readers = new ArrayList<>();

        for (String fileName : CSV_FILE_PATHS) {
            try {
                readers.add(new CSVReader(new File(Main.class.getResource(fileName).toURI()), ";"));
            } catch (Exception e) {
                // do nothing
            }
        }

        for (CSVReader reader : readers) {
            reader.setSkipHeader(true);
            try {
                List<String[]> lines = reader.read();
                for (String[] line : lines) {
                    for (String word : line) {
                        System.out.printf("%s ", word);
                    }
                    System.out.println();
                }
                System.out.println();
            } catch (Exception e) {
                // do nothing
            }
        }
    }
}
