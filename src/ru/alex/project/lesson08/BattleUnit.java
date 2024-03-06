package ru.alex.project.lesson08;

public class BattleUnit extends Unit{
    private int attackPoint;

    public int getAttackPoint() {
        return attackPoint;
    }

    public BattleUnit(int healthPoint, int speedPoint, int attackPoint) {
        super(healthPoint, speedPoint);
        this.attackPoint = attackPoint;
    }

    public void attack(Unit unit){

    }


    @Override
    public void rest(){
        if(healthPoint > 0 && healthPoint < InitialHealthPoint){
            healthPoint += 2;
        }
    }
}
