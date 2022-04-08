package com.monstersaku.pools;

import java.util.HashMap;
import java.util.List;

import com.monstersaku.enums.ElementType;
import com.monstersaku.util.CSVReader;

public class EffectivityPool {
    public static CSVReader reader;
    private static EffectivityPool INSTANCE = null;

    private HashMap<String, Double> effectList;
    
    private EffectivityPool () {
        this.effectList = new HashMap<String, Double>();
    }

    public static void setReader(CSVReader csvreader) {
        if (reader == null) {
            EffectivityPool.reader = csvreader;
        }
    }

    public static EffectivityPool getEffectivityPool () {
        if (INSTANCE == null) {
            INSTANCE = new EffectivityPool();
        }
        return INSTANCE;
    }

    public void addEffectivity(ElementType source, ElementType target, double effectivity) {
        String key = source.toString() + "," + target.toString(); 
        this.effectList.put(key, effectivity);
    } 

    public double getEffectivity(ElementType source, ElementType target) {
        String key = source.toString() + "," + target.toString();
        double effectivity = this.effectList.get(key);
        return effectivity;
    }

    public void readEffectivities() {
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
                    this.addEffectivity(source, target, effectivity);
                } catch (IllegalArgumentException e) {
                    System.out.println("[IllegalArgumentException] " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("[Exception] " + e.getMessage());
                }
            }
        } catch (Exception e) { }
    }
}