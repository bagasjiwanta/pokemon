package com.monstersaku.pools;

import java.util.HashMap;

import com.monstersaku.enums.ElementType;

public class EffectivityPool {

    private static EffectivityPool INSTANCE = null;

    private HashMap<String, Double> effectList;
    
    private EffectivityPool () {
        this.effectList = new HashMap<String, Double>();
    }

    public static EffectivityPool getEffectivityPool () {
        if (INSTANCE == null) {
            INSTANCE = new EffectivityPool();
        }
        return INSTANCE;
    }

    public void add(ElementType source, ElementType target, double effectivity) {
        String key = source.toString() + "," + target.toString();
        this.effectList.put(key, effectivity);
    } 

    public double getEffectivity (ElementType source, ElementType target) {
        String key = source.toString() + "," + target.toString();
        double effectivity = this.effectList.get(key);
        if (effectivity == 0.0) {
            return -1;
        } else {
            return effectivity;
        }
    }
}