package com.monstersaku.moves;
import com.monstersaku.Monster;
import com.monstersaku.Stats;
import com.monstersaku.enums.ElementType;
import com.monstersaku.enums.MoveType;
import com.monstersaku.enums.StatusCondition;

public class StatusMove extends Move {
    private String target;
    private StatusCondition effectCondition;
    private Stats stats;

    public StatusMove (
        int id,
        MoveType moveType,
        String name,
        ElementType elementType,
        int accuracy,
        int priority,
        int ammunition,
        String target,
        StatusCondition effectCondition,
        Stats stats
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
        this.target = target;
        this.effectCondition = effectCondition;
        this.stats = stats;
    }

    public StatusCondition getCondition() {
        return this.effectCondition;
    }

    public String getTarget() {
        return this.target;
    }

    public void execute(Monster own, Monster enemy) {
        super.reduceAmmunition();

        if (this.target.equals("ENEMY")) {
            if (enemy.getEffect() == StatusCondition.NONE) {
                enemy.setCondition(getCondition());
            }
            enemy.alterStats(this.stats);
        } else {
            own.alterStats(this.stats);
        }

        if (this.target == "ENEMY") {
            System.out.println("Move sukses, " + enemy.getNama() + " terkena " + enemy.getEffect().toString());
        } else {
            System.out.println("Move sukses");
        }
         
    }
}
