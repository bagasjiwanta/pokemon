package com.monstersaku;

public abstract class Move {
    private String name;
    private ElementType elementType;
    private int accuracy;
    private int priority;
    private int ammunition;

    public Move(String name, ElementType elementType, int accuracy, int priority, int ammunition){
        this.name = name;
        this.elementType = elementType;
        this.accuracy = accuracy;
        this.priority = priority;
        this.ammunition = ammunition;
    };

    public String getMoveName(){
        return name;
    }
    public ElementType getMoveElementType(){
        return elementType;
    }
    public int getAccuracy(){
        return accuracy;
    }
    public int getPriority(){
        return priority;
    }
    public int getAmmunition(){
        return ammunition;
    }
    public void reduceAmmunition(){
        ammunition --; 
    }

    public void execute(Monster allyMonster, Monster enemyMonster){}

}
