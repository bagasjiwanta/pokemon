package com.monstersaku.moves;
import com.monstersaku.Monster;
import com.monstersaku.enums.ElementType;
import com.monstersaku.enums.MoveType;
import com.monstersaku.enums.StatusCondition;
import com.monstersaku.pools.EffectivityPool;

public class StatusMove extends Move {
    private String target;
    private StatusCondition effectCondition;
    public StatusMove (
        int id,
        MoveType moveType,
        String name,
        ElementType elementType,
        int accuracy,
        int priority,
        int ammunition,
        String target,
        StatusCondition effectCondition
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
        this.target = target;
        this.effectCondition = effectCondition;
    }

    public void execute(Monster source, Monster target) {
        EffectivityPool effectivityPool = EffectivityPool.getEffectivityPool();
    }
}
