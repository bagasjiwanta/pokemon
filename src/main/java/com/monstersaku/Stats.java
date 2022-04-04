package com.monstersaku;

import java.util.List;
import java.util.ArrayList;

public class Stats {

    private double healthPoint;
    private double attack;
    private double defense;
    private double specialAttack;
    private double specialDefense;
    private double speed;

    public Stats (List<Double> stats) throws IllegalArgumentException {
        if (stats.size() < 6) {
            throw new IllegalArgumentException();
        }
        setHealthPoint(stats.get(0));
        setAttack(stats.get(1));
        setDefense(stats.get(2));
        setSpecialAttack(stats.get(3));
        setSpecialDefense(stats.get(4));
        setSpeed(stats.get(5));
    }

    public double getHealthPoint() {
        return this.healthPoint;
    }

    public void setHealthPoint(double healthPoint) {
        this.healthPoint = healthPoint;
    }

    public double getAttack() {
        return this.attack;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public Double getDefense() {
        return this.defense;
    }

    public void setDefense(Double defense) {
        this.defense = defense;
    }

    public double getSpecialAttack() {
        return this.specialAttack;
    }

    public void setSpecialAttack(double specialAttack) {
        this.specialAttack = specialAttack;
    }

    public double specialDefense() {
        return this.specialDefense;
    }

    public void setSpecialDefense(double specialDefense) {
        this.specialDefense = specialDefense;
    }

    public double getSpeed() {
        return this.speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public List<Double> getAll() {
        List<Double> statList = new ArrayList<Double>();
        statList.add(this.healthPoint);
        statList.add(this.attack);
        statList.add(this.defense);
        statList.add(this.specialAttack);
        statList.add(this.specialDefense);
        statList.add(this.speed);
        return statList;
    }
}
