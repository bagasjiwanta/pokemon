package com.monstersaku.moves;
import com.monstersaku.Monster;
import com.monstersaku.enums.ElementType;
import com.monstersaku.enums.MoveType;
import com.monstersaku.enums.StatusCondition;
import com.monstersaku.pools.EffectivityPool;

public class DefaultMove extends Move {
    private static final int basePower = 50;

    public DefaultMove (int id, String name) {
        super(id, MoveType.DEFAULT, name, ElementType.NORMAL, 100, 0, 1);
    }

    public void execute(Monster own, Monster enemy){
        super.reduceAmmunition();
        if (doesItMiss()) {
            System.out.println("Default Move miss");
            return;
        }

        if (own.isParalyzed()) {
            System.out.println("Default Move failed due to pokemon being paralyzed");
            return;
        }

        if (own.isSleeping()) {
            System.out.println("Default Move failed due to pokemon being sleeping");
            return;
        }

        double effectivity = 1;
        for (ElementType e : enemy.getElementTypes()) {
            effectivity *= EffectivityPool.getEffectivity(this.elementType, e);
        }
        if (own.getEffect().equals(StatusCondition.BURN)) {
            double damage = (basePower * own.getStats().getAttack()/enemy.getStats().getDefense() + 2) * Math.random()*(1-0.85+1)+0.85 * effectivity * 0.125 * enemy.getStats().getMaxHP();
            enemy.getStats().decreaseHP(damage);
            own.getStats().decreaseHP(own.getStats().getMaxHP()/4);
        } else {
            double damage = (basePower * own.getStats().getAttack()/enemy.getStats().getDefense() + 2) * Math.random()*(1-0.85+1)+0.85 * effectivity;
            enemy.getStats().decreaseHP(damage);
            own.getStats().decreaseHP(own.getStats().getMaxHP()/4);
            System.out.println("Mengeksekusi Default Move, damage : " + damage);
        }
    }
}