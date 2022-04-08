package com.monstersaku.moves;
import com.monstersaku.Monster;
import com.monstersaku.enums.ElementType;
import com.monstersaku.enums.MoveType;
import com.monstersaku.enums.StatusCondition;

public class StatusMove extends Move {
    private String target;
    private StatusCondition effectCondition;

    public StatusMove (
        int id,
        MoveType moveType,
        String name,
        ElementType elementType,
        int accuracy,
        int priority,
        int ammunition,
        String target,
        StatusCondition effectCondition
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
    }

    public StatusCondition getCondition() {
        return this.effectCondition;
    }

    public String getTarget() {
        return this.target;
    }

    public void execute(Monster own, Monster enemy) {

        // ini diganti yg setEffect jdi alterEffect
        // bikin fungsi dulu di monsternya
        // liat di spesifikasi hal 14 yg awal awal tuh
        if (this.target.equals("ENEMY")) {
            enemy.setEffect(getCondition());
        } else {
            own.setEffect(getCondition());
        }
        super.reduceAmmunition();
        System.out.println("Mengeksekusi Normal Move");
    }
}
