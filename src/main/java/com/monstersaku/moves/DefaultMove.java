package com.monstersaku.moves;
import com.monstersaku.Monster;
import com.monstersaku.enums.ElementType;
import com.monstersaku.enums.MoveType;
import com.monstersaku.enums.StatusCondition;
import com.monstersaku.pools.EffectivityPool;

// public class DefaultMove extends Move {
//     public DefaultMove (
//         int id,
//         MoveType moveType,
//         String name,
//         ElementType elementType,
//         int accuracy,
//         int priority,
//         int ammunition
//     ) {
//         super (
//             id,
//             moveType,
//             name,
//             elementType,
//             accuracy,
//             priority,
//             ammunition
//         );
//     }

//     public void execute(Monster source, Monster target) {
//         EffectivityPool effectivityPool = EffectivityPool.getEffectivityPool();
//     }
// }

public class DefaultMove extends Move {
    private static final int basePower = 50;

    public DefaultMove (int id, String name) {
        super(id, MoveType.DEFAULT, name, ElementType.NORMAL, 100, 0, 1);
    }

    public void execute(Monster allyMonster, Monster enemyMonster){
        if (allyMonster.getEffect().equals(StatusCondition.BURN)) {
            double damage = (basePower * allyMonster.getStats().getAttack()/enemyMonster.getStats().getDefense() + 2) * Math.random()*(1-0.85+1)+0.85 * 1 /** ElementEffectivity */ * 0.5 /** Burn */;
            enemyMonster.getStats().setHealthPoint(damage);
            allyMonster.getStats().setHealthPoint(allyMonster.getStats().getMaxHP()/4);
        } else {
            double damage = (basePower * allyMonster.getStats().getAttack()/enemyMonster.getStats().getDefense() + 2) * Math.random()*(1-0.85+1)+0.85 * 1 /** ElementEffectivity */ * 1 /** Burn */;
            enemyMonster.getStats().setHealthPoint(damage);
            allyMonster.getStats().setHealthPoint(allyMonster.getStats().getMaxHP()/4);
        }
    }
}