package ru.alex.project.lesson06.lesson09.abstr;

public class Building implements Colorable{
    public void color(String color){
        System.out.println("Покраска в " + color + " цвет");
    }

    public void abc(){
        System.out.println("test");
    }


    public static void main(String[] args) {
        Building building = new Building();
        Colorable colorable = new Building();

    }
}
