package com.monstersaku.moves;
import com.monstersaku.Monster;
import com.monstersaku.enums.ElementType;
import com.monstersaku.enums.MoveType;
import com.monstersaku.pools.EffectivityPool;

public class DefaultMove extends Move {
    public DefaultMove (
        int id,
        MoveType moveType,
        String name,
        ElementType elementType,
        int accuracy,
        int priority,
        int ammunition
    ) {
        super (
            id,
            moveType,
            name,
            elementType,
            accuracy,
            priority,
            ammunition
        );
    }

    public void execute(Monster source, Monster target) {
        EffectivityPool effectivityPool = EffectivityPool.getEffectivityPool();
    }
}
