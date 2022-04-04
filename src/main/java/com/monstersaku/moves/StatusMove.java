package com.monstersaku.moves;
import com.monstersaku.EffectivityPool;
import com.monstersaku.ElementType;
import com.monstersaku.Monster;
import com.monstersaku.MoveType;
import com.monstersaku.StatusCondition;

public class StatusMove extends Move {
    
    public StatusMove (
        MoveType moveType,
        String name,
        ElementType elementType,
        int accuracy,
        int priority,
        int ammunition,
        String target,
        StatusCondition statusCondition
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
