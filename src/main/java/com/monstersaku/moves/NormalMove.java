package com.monstersaku.moves;
import com.monstersaku.Monster;
import com.monstersaku.enums.ElementType;
import com.monstersaku.enums.MoveType;
import com.monstersaku.enums.StatusCondition;
import com.monstersaku.pools.EffectivityPool;

public class NormalMove extends Move{
    private int basePower;

    public NormalMove (
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

    public void execute(Monster own, Monster enemy) {
        double effectivity = 1;
        for (ElementType e : enemy.getElementTypes()) {
            effectivity *= EffectivityPool.getEffectivity(this.elementType, e);
        }
        if (own.getEffect().equals(StatusCondition.BURN)) {
            double damage = (this.basePower * own.getStats().getAttack()/enemy.getStats().getDefense() + 2) * Math.random()*(1-0.85+1)+0.85 * effectivity * 0.125 * enemy.getStats().getMaxHP();
            enemy.getStats().decreaseHP(damage);
            super.reduceAmmunition();
        } else {
            double damage = (this.basePower * own.getStats().getAttack()/enemy.getStats().getDefense() + 2) * Math.random()*(1-0.85+1)+0.85 * effectivity;
            enemy.getStats().decreaseHP(damage);
            super.reduceAmmunition();
            System.out.println("Mengeksekusi Normal Move, damage : " + damage);
        }
    }
}
