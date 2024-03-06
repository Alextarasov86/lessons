package ru.alex.project.lesson08;

public class Unit {
    protected int healthPoint;
    private int speedPoint;
    protected int InitialHealthPoint;

    public int getHealthPoint() {
        return healthPoint;
    }

    public int getSpeedPoint() {
        return speedPoint;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public Unit(int healthPoint){
        this.healthPoint = healthPoint;
        this.InitialHealthPoint = healthPoint;
    }

    public Unit(int healthPoint, int speedPoint) {
        this.healthPoint = healthPoint;
        this.speedPoint = speedPoint;
        this.InitialHealthPoint = healthPoint;
    }

    public void rest(){
        if(healthPoint > 0 && healthPoint < InitialHealthPoint){
            healthPoint++;
        }
    }

}
