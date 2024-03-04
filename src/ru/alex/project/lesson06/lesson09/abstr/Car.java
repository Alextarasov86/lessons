package ru.alex.project.lesson06.lesson09.abstr;

public class Car extends Vehicle implements Colorable{
    public void color(String color){
        System.out.println("Покраска");
    }

}
