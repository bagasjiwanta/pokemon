package com.tubes;

public class StatusMove extends Move{
    private StatusCondition condition;
    public StatusMove(String name, ElementType elementType, int accuracy, int priority, int ammunition, StatusCondition condition){
        super(name,elementType, accuracy, priority, ammunition);
        this.condition = condition;
    }

    public StatusCondition getCondition(){
        return condition;
    }

    public void execute(Monster allyMonster, Monster enemyMonster){
        enemyMonster.setEffect(getCondition());
        super.reduceAmmunition();
    }
}
