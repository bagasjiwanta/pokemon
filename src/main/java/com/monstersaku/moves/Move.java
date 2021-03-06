package com.monstersaku.moves;

import java.util.Random;

import com.monstersaku.Monster;
import com.monstersaku.enums.ElementType;
import com.monstersaku.enums.MoveType;

public abstract class Move {
    protected int id;
    protected String name;
    protected ElementType elementType;
    protected int accuracy;
    protected int priority;
    protected int ammunition;

    public Move (
        int id,
        MoveType moveType,
        String name,
        ElementType elementType,
        int accuracy,
        int priority,
        int ammunition
    ) {
        this.id = id;
        this.name = name;
        this.elementType = elementType;
        this.accuracy = accuracy;
        this.priority = priority;
        this.ammunition = ammunition;
    }

    public String getName () {
        return this.name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public ElementType getElementType () {
        return this.elementType;
    }

    public void setElementType (ElementType elementType) {
        this.elementType = elementType;
    }

    public int getAccuracy () {
        return this.accuracy;
    }

    public void setAccuracy (int accuracy) {
        this.accuracy = accuracy;
    }

    public int getPriority () {
        return this.priority;
    }

    public void setPriority (int priority) {
        this.priority = priority;
    }

    public int getAmmunition () {
        return this.ammunition;
    }

    public void setAmmunition(int ammunition) {
        this.ammunition = ammunition;
    }

    public void reduceAmmunition() {
        this.ammunition --;
    }

    public boolean doesItMiss () {
        Random random = new Random (this.id);
        int rand = random.nextInt(this.ammunition + 1);
        return rand >= this.ammunition;
    }

    public boolean isAmmoEnough() {
        return this.ammunition != 0;
    }

    public void validateMove (Monster own) { 
        if (!own.isMonsterAlive()) {
            System.out.println(own.getNama() + " sudah mati, ganti ke pokemon lain");
            return;
        }

        if (own.isSleeping()) {
            System.out.println("Normal Move failed due to pokemon being sleeping");
            return;
        }

        if (own.isParalyzed()) {
            System.out.println("Normal Move failed due to pokemon being paralyzed");
        }

        if (doesItMiss()) {
            System.out.println("Normal move miss");
        }

        if (!(this instanceof DefaultMove)) {
            this.reduceAmmunition();
        }
        return;
    }

    public abstract void execute (Monster source, Monster target);
}
