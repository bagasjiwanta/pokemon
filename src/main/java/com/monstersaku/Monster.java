package com.monstersaku;

import java.util.List;

public class Monster {
    private String nama;
    private List<ElementType> elementTypes;
    private Stats baseStats;

    public Monster() {}

    public String getNama() {
        return this.nama;
    }

    public List<ElementType> getElementTypes() {
        return this.elementTypes;
    }

    public Stats getBaseStats() {
        return this.baseStats;
    }
}
