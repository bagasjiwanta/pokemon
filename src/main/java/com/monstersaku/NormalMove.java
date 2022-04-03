package com.monstersaku;

public class NormalMove extends Move {
    public NormalMove (
        String name,
        ElementType elementType,
        int accuracy,
        int priority,
        int ammunition
    ) { super (name, elementType, accuracy, priority, ammunition);}

    private int basePower;

    public void execute (Monster source, Monster target, EffectivityPool E){
    };
}
