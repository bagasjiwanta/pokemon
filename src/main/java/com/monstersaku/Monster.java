package com.monstersaku;

import java.util.ArrayList;


/* INI CUMA DUMMY BUAT NYELESAIN MOVE */

public class Monster {
    private String name;
    private ElementType elementType;
    private Stats baseStats;
    private ArrayList<Move> moves = new ArrayList<Move>();
    private StatusCondition effect;

    public Monster(){
        
    }

    public Stats getStats(){
        return baseStats;
    }
    public StatusCondition getEffect(){
        return effect;
    }
    public void setEffect(StatusCondition newEffect){
        effect = newEffect;
    }

}
