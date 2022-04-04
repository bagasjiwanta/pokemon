package com.monstersaku;

import java.util.List;

import com.monstersaku.enums.ElementType;
import com.monstersaku.enums.StatusCondition;
import com.monstersaku.moves.Move;
import com.monstersaku.pools.MovePool;

public class Monster {
    private String nama;
    private List<ElementType> elementTypes;
    private Stats baseStats;
    private StatusCondition statusCondition;
    private MovePool movePool;

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
        for (Move m : moves) {
            this.movePool.add(m);
        }
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

    public void displayMoves() {
        System.out.println("Pokemon " + this.nama + " memiliki move-move berikut: ");
        for (int x = 0; x < movePool.getNumberOfMoves(); x++) {
            System.out.println(x + ". " + movePool.getMoveByIndex(x));
        }
    }
}
