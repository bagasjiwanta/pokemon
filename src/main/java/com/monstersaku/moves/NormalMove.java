package com.monstersaku.moves;
import com.monstersaku.Monster;
import com.monstersaku.enums.ElementType;
import com.monstersaku.enums.MoveType;
import com.monstersaku.pools.EffectivityPool;

public class NormalMove extends Move{

    public NormalMove (
        MoveType moveType,
        String name,
        ElementType elementType,
        int accuracy,
        int priority,
        int ammunition,
        String target
    ) {
        super (
            moveType,
            name,
            elementType,
            accuracy,
            priority,
            ammunition,
            target
        );
    }

    public void execute(Monster source, Monster target) {
        EffectivityPool effectivityPool = EffectivityPool.getEffectivityPool();
    }
}
