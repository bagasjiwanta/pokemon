package com.monstersaku.moves;
import java.util.Random;
import com.monstersaku.Monster;
import com.monstersaku.enums.ElementType;
import com.monstersaku.enums.MoveType;
import com.monstersaku.pools.EffectivityPool;

public class DefaultMove extends Move {
    private static final int basePower = 50;

    public DefaultMove (int id, String name) {
        super(id, MoveType.DEFAULT, name, ElementType.NORMAL, 100, 0, 1);
    }

    public void execute(Monster own, Monster enemy){
        double effectivity = 1;
        for (ElementType e : enemy.getElementTypes()) {
            effectivity *= EffectivityPool.getEffectivity(this.elementType, e);
        }

        /** EXECUTE */
        Random random = new Random();
        double damage = (basePower * own.getStats().getAttack()/enemy.getStats().getDefense() + 2) * ((random.nextInt(101 - 85) + 85) * 0.01) * effectivity * own.burnMultiplier();
        enemy.getStats().decreaseHP(damage);
        System.out.println("Mengeksekusi Default Move, damage : " + damage);
    }
}