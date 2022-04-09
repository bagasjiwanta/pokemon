package com.monstersaku.moves;
import java.util.Random;
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
        if (ammunition > 0) {
            super.reduceAmmunition();
            if (doesItMiss()) {
                System.out.println("Normal move miss");
                return;
            }
    
            if (own.isParalyzed()) {
                System.out.println("Normal Move failed due to pokemon being paralyzed");
                return;
            }
    
            if (own.isSleeping()) {
                System.out.println("Normal Move failed due to pokemon being sleeping");
                return;
            }
    
            double effectivity = 1;
            for (ElementType e : enemy.getElementTypes()) {
                effectivity *= EffectivityPool.getEffectivity(this.elementType, e);
            }

            /** EXECUTE */
            Random random = new Random();
            double damage = (this.basePower * own.getStats().getAttack()/enemy.getStats().getDefense() + 2) * ((random.nextInt(101 - 85) + 85) * 0.01) * effectivity * own.burnMultiplier();
            enemy.getStats().decreaseHP(damage);
            System.out.println("Mengeksekusi Normal Move, damage : " + damage);

        } else {
            System.out.println("Move out of ammunition");
        }
    }
}
