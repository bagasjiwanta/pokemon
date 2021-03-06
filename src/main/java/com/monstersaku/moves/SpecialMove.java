package com.monstersaku.moves;
import java.util.Random;
import com.monstersaku.Monster;
import com.monstersaku.enums.ElementType;
import com.monstersaku.enums.MoveType;
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

        double effectivity = 1;
        for (ElementType e : enemy.getElementTypes()) {
            effectivity *= EffectivityPool.getEffectivity(this.elementType, e);
        }
        
        /** EXECUTE */
        Random random = new Random();
        double damage = (this.basePower * own.getStats().getSpecialAttack()/enemy.getStats().getSpecialDefense() + 2) * ((random.nextInt(101 - 85) + 85) * 0.01) * effectivity * own.burnMultiplier();
        enemy.getStats().decreaseHP(damage);
    } 
    
}
