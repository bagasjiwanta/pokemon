package com.monstersaku;

import java.util.List;

public class Monster {
    private String nama;
    private List<ElementType> elementTypes;
    private Stats baseStats;
    private StatusCondition statusCondition;
    private List<Move> moves;

    public Monster (
        String nama,
        List<ElementType> elementTypes,
        Stats baseStats,
        List<Move> moves
    ) {
        this.nama = nama;
        this.elementTypes = elementTypes;
        this.baseStats = baseStats;
        this.statusCondition = StatusCondition.NONE;
        this.moves = moves;
    }

    public String getNama() {
        return this.nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public List<ElementType> getElementTypes() {
        return this.elementTypes;
    }

    public void addElementType(ElementType elementType) {
        this.elementTypes.add(elementType);
    }

    public Stats getBaseStats() {
        return this.baseStats;
    }

    public StatusCondition getStatusCondition() {
        return this.statusCondition;
    }

    public List<Move> getMoves() {
        return this.moves;
    }

}
