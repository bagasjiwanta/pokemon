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

    public StatusCondition getCondition() {
        return this.effectCondition;
    }

    public String getTarget() {
        return this.target;
    }

    public void execute(Monster allyMonster, Monster enemyMonster) {
        if (this.target.equals("ENEMY")) {
            enemyMonster.setEffect(getCondition());
        } else {
            
        }
        super.reduceAmmunition();
    }
}
