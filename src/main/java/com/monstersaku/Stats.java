package com.tubes;

/* INI CUMA DUMMY BUAT NYELESAIN MOVE */

public class Stats {
    private double healthPoint;
    private static double maxHP;
    private double attack;
    private double defense;
    private double specialAttack;
    private double specialDefense;
    private double speed;

    public Stats(double healthPoint, double attack, double defense, double specialAttack, double specialDefense, double speed) {
        this.healthPoint = healthPoint;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.speed = speed;
        maxHP = healthPoint;
    }

    // Getter
    public double getHealthPoint(){
        return healthPoint;
    }
    public double getDefense(){
        return defense;
    }
    public double getAttack(){
        return attack;
    }
    public double getSpecialAttack(){
        return specialAttack;
    }
    public double getSpecialDefense(){
        return specialDefense;
    }
    public double getSpeed(){
        return speed;
    }

    public double getMaxHP(){
        return maxHP;
    }

    // Untuk pengurangan HP Monster
    public void setHealthPoint(double damage){
        healthPoint -= damage;
    }
}
