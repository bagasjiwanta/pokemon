package com.monstersaku;

import java.util.List;
import java.util.ArrayList;

public class Stats<T> {

    private T healthPoint;
    private T attack;
    private T defense;
    private T specialAttack;
    private T specialDefense;
    private T speed;

    public Stats(
        T healthPoint, 
        T attack,
        T defense,
        T specialAttack,
        T specialDefense,
        T speed
    ) {
        setHealthPoint(healthPoint);
        setAttack(attack);
        setDefense(defense);
        setSpecialAttack(specialAttack);
        setSpecialDefense(specialDefense);
        setSpeed(speed);
    }

    public T getHealthPoint() {
        return this.healthPoint;
    }

    public void setHealthPoint(T healthPoint) {
        this.healthPoint = healthPoint;
    }

    public T getAttack() {
        return this.attack;
    }

    public void setAttack(T attack) {
        this.attack = attack;
    }

    public T getDefense() {
        return this.defense;
    }

    public void setDefense(T defense) {
        this.defense = defense;
    }

    public T getSpecialAttack() {
        return this.specialAttack;
    }

    public void setSpecialAttack(T specialAttack) {
        this.specialAttack = specialAttack;
    }

    public T specialDefense() {
        return this.specialDefense;
    }

    public void setSpecialDefense(T specialDefense) {
        this.specialDefense = specialDefense;
    }

    public T getSpeed() {
        return this.speed;
    }

    public void setSpeed(T speed) {
        this.speed = speed;
    }

    public List<T> getAll() {
        List<T> statList = new ArrayList<T>();
        statList.add(this.healthPoint);
        statList.add(this.attack);
        statList.add(this.defense);
        statList.add(this.specialAttack);
        statList.add(this.specialDefense);
        statList.add(this.speed);
        return statList;
    }
}
