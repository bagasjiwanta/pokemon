package com.monstersaku.moves;
import com.monstersaku.Monster;
import com.monstersaku.enums.ElementType;
import com.monstersaku.enums.MoveType;
import com.monstersaku.enums.StatusCondition;

public class SpecialMove extends Move {
    private int basePower;

    public SpecialMove (
        int id,
        MoveType moveType,
        String name,
        ElementType elementType,
        int accuracy,
        int priority,
        int ammunition,
        int basePower
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
        this.basePower = basePower;
    }

    @Override
    public void execute(Monster allyMonster, Monster enemyMonster) {
        if (allyMonster.getEffect().equals(StatusCondition.BURN)) {
            double damage = (this.basePower * allyMonster.getStats().getSpecialAttack()/enemyMonster.getStats().getSpecialDefense() + 2) * Math.random()*(1-0.85+1)+0.85 * 1 /** ElementEffectivity */ * 0.5 /** Burn */;
            enemyMonster.getStats().setHealthPoint(damage);
            super.reduceAmmunition();
        } else {
            double damage = (this.basePower * allyMonster.getStats().getSpecialAttack()/enemyMonster.getStats().getSpecialDefense() + 2) * Math.random()*(1-0.85+1)+0.85 * 1 /** ElementEffectivity */ * 1 /** Burn */;
            enemyMonster.getStats().setHealthPoint(damage);
            super.reduceAmmunition();
        }
    };
}
