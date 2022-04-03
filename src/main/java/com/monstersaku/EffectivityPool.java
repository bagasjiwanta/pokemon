package com.monstersaku;

import java.util.HashMap;

public class EffectivityPool {

    private HashMap<String, Double> effectList;
    
    public EffectivityPool () {
        this.effectList = new HashMap<String, Double>();
    }

    public void add(String source, String target, double effectivity) {
        String sourcetarget = source + "," + target;
        String targetsource = target + "," + source;
        this.effectList.put(sourcetarget, effectivity);
        try {
            this.effectList.put(targetsource, 1 / effectivity);
        } catch (Exception e) {
            System.out.println("EffectivityPool.add");
        }
    } 

    public double getEffectivity (ElementType source, ElementType target) {
        String args = source.getName() + "," + target.getName();
        double effectivity = this.effectList.get(args);
        if (effectivity == 0.0) {
            return -1;
        } else {
            return effectivity;
        }
    }
}