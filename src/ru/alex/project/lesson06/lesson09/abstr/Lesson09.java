package ru.alex.project.lesson06.lesson09.abstr;

public class Lesson09 {
    public static void main(String[] args) {
        Car car = new Car();
        Train train = new Train();

        Vehicle[] vehicles = {car, train};
        for (Vehicle vehicle : vehicles) {
            if(vehicle instanceof Car){
                Car vCar = (Car) vehicle;

            }
        }
    }
}
