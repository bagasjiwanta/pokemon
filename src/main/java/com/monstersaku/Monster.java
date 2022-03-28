package com.monstersaku;

import java.util.List;

public class Monster {
    private String nama;
    private List<ElementType> elementTypes;
    private Stats<Double> baseStats;

    public Monster() {}

    public String getNama() {
        return this.nama;
    }

    public List<ElementType> getElementTypes() {
        return this.elementTypes;
    }

    public Stats<Double> getBaseStats() {
        return this.baseStats;
    }
}
