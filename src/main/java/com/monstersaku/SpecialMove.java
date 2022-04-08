package com.monstersaku;

public class SpecialMove extends Move {
    private int basePower;
    public SpecialMove(String name, ElementType elementType, int accuracy, int priority, int ammunition,int basePower){
        super(name,elementType, accuracy, priority, ammunition);
        this.basePower = basePower;
    }

    public int getMoveBasePower(){
        return basePower;
    }

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