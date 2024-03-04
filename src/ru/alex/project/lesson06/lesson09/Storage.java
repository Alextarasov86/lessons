package ru.alex.project.lesson06.lesson09;

public class Storage {
    private final String title;
    private final Apple apple = new Apple();
    private final Apple[] apples = new Apple[10];

    public Storage(String title){
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public Apple[] getApples() {
        return apples;
    }

    public static void main(String[] args) {
        Storage storage = new Storage("goods");
    }
}
