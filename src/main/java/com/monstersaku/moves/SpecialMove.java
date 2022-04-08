package com.monstersaku.moves;
import com.monstersaku.Monster;
import com.monstersaku.enums.ElementType;
import com.monstersaku.enums.MoveType;
import com.monstersaku.enums.StatusCondition;
import com.monstersaku.pools.EffectivityPool;

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
    public void execute(Monster own, Monster enemy) {
        super.reduceAmmunition();
        if (doesItMiss()) {
            System.out.println("Special Move miss");
            return;
        }

        if (own.isParalyzed()) {
            System.out.println("Special Move failed due to pokemon being paralyzed");
            return;
        }

        if (own.isSleeping()) {
            System.out.println("Special Move failed due to pokemon being sleeping");
            return;
        }

        double effectivity = 1;
        for (ElementType e : enemy.getElementTypes()) {
            effectivity *= EffectivityPool.getEffectivity(this.elementType, e);
        }
        if (own.getEffect().equals(StatusCondition.BURN)) {
            double damage = (this.basePower * own.getStats().getSpecialAttack()/enemy.getStats().getSpecialDefense() + 2) * Math.random()*(1-0.85+1)+0.85 * effectivity * 0.125 * enemy.getStats().getMaxHP();
            enemy.getStats().decreaseHP(damage);
        } else {
            double damage = (this.basePower * own.getStats().getSpecialAttack()/enemy.getStats().getSpecialDefense() + 2) * Math.random()*(1-0.85+1)+0.85 * effectivity;
            enemy.getStats().decreaseHP(damage);
            System.out.println("Mengeksekusi Special Move, damage : " + damage);
        }
    };
}
