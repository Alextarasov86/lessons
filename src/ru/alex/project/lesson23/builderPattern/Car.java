package ru.alex.project.lesson23.builderPattern;

public class Car {
    String make;
    Transmission transmission;
    int maxSpeed;

    public enum Transmission{
        MANUAL, AUTO
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
