package ru.alex.project.lesson23.builderPattern;

public class CarBuilder {
    String m = "Default";
    Car.Transmission t = Car.Transmission.MANUAL;
    int s = 120;

    CarBuilder buildMake(String m){
        this.m = m;
        return this;
    }
    CarBuilder buildTransmission(Car.Transmission t){
        this.t = t;
        return this;
    }
    CarBuilder buildMaxSpeed(int s){
        this.s = s;
        return this;
    }

    Car build(){
        Car car = new Car();
        car.setMake(m);
        car.setTransmission(t);
        car.setMaxSpeed(s);
        return car;
    }
}
