package com.monstersaku.pools;

import java.util.HashMap;
import java.util.List;

import com.monstersaku.enums.ElementType;
import com.monstersaku.util.CSVReader;

public class EffectivityPool {
    public static CSVReader reader;

    public static HashMap<String, Double> effectList = new HashMap<String, Double>();

    public static void addEffectivity(ElementType source, ElementType target, double effectivity) {
        String key = source.toString() + "," + target.toString(); 
        EffectivityPool.effectList.put(key, effectivity);
    } 

    public static double getEffectivity(ElementType source, ElementType target) {
        String key = source.toString() + "," + target.toString();
        double effectivity = EffectivityPool.effectList.get(key);
        return effectivity;
    }

    public static void setReader(CSVReader csvreader) {
        EffectivityPool.reader = csvreader;
    }

    public static void readEffectivities() {
        if (EffectivityPool.reader == null) {
            return;
        }

        EffectivityPool.reader.setSkipHeader(true);
        try {
            List<String[]> lines = EffectivityPool.reader.read();
            for (String[] line : lines) {
                ElementType source, target;
                try {
                    source = ElementType.valueOf(line[0]);
                    target = ElementType.valueOf(line[1]);
                    double effectivity = Double.parseDouble(line[2]);
                    EffectivityPool.addEffectivity(source, target, effectivity);
                } catch (IllegalArgumentException e) {
                    System.out.println("[IllegalArgumentException] " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("[Exception] " + e.getMessage());
                }
            }
        } catch (Exception e) { }
    }
}