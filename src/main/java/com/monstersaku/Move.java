package com.monstersaku;

public class Move {
    private String name;
    private ElementType elementType;
    private int accuracy;
    private int priority;
    private int ammunition;
    private MoveType moveType;

    public Move(
        MoveType moveType,
        String name,
        ElementType elementType,
        int accuracy,
        int priority,
        int ammunition
    ) {
        this.name = name;
        this.moveType = moveType;

        if (moveType == MoveType.DEFAULT) {
            this.elementType = ElementType.NORMAL;
            this.accuracy = 100;
            this.priority = 0;
            this.ammunition = 1;
            return;
        }

        this.elementType = elementType;
        this.accuracy = accuracy;
        this.priority = priority;
        this.ammunition = ammunition;
    }
}
