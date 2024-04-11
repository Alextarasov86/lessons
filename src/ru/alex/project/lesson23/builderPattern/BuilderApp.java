package ru.alex.project.lesson23.builderPattern;

public class BuilderApp {
    public static void main(String[] args) {
        Car car = new CarBuilder().
                buildMake("Kia").
                buildTransmission(Car.Transmission.AUTO).
                buildMaxSpeed(190).
                build();
    }
}

