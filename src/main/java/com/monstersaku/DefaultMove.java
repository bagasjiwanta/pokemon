package com.monstersaku;

public class DefaultMove extends Move {
    private int basePower;
    public DefaultMove(String name, ElementType elementType){
        super(name, ElementType.NORMAL, 100, 0, 9999);
        this.basePower = 50;
    }

    public void execute(Monster allyMonster, Monster enemyMonster){
        if (allyMonster.getEffect().equals(StatusCondition.BURN)) {
            double damage = (this.basePower * allyMonster.getStats().getAttack()/enemyMonster.getStats().getDefense() + 2) * Math.random()*(1-0.85+1)+0.85 * 1 /** ElementEffectivity */ * 0.5 /** Burn */;
            enemyMonster.getStats().setHealthPoint(damage);
            allyMonster.getStats().setHealthPoint(allyMonster.getStats().getMaxHP()/4);
        } else {
            double damage = (this.basePower * allyMonster.getStats().getAttack()/enemyMonster.getStats().getDefense() + 2) * Math.random()*(1-0.85+1)+0.85 * 1 /** ElementEffectivity */ * 1 /** Burn */;
            enemyMonster.getStats().setHealthPoint(damage);
            allyMonster.getStats().setHealthPoint(allyMonster.getStats().getMaxHP()/4);
        }
    }
}
