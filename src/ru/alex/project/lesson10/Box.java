package ru.alex.project.lesson10;

public class Box {
    private static int numberOfBox;
    private int height;
    private int width;
    private int length;

    public Box(int height, int width, int length) {
        this.height = height;
        this.width = width;
        this.length = length;
    }

    public void grow(int heightInc, int widthInc, int lengthInc){
        this.height += heightInc;
        this.width += widthInc;
        this.length += lengthInc;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public static void incNumberOfBoxes(){
        numberOfBox++;
    }

    public static int getNumberOfBox() {
        return numberOfBox;
    }

    public static void main(String[] args) {
        Box box01 = new Box(12, 67, 20);
        Box box02 = new Box(30, 30, 30);
        Box box03 = new Box(100, 110, 120);

        box02.grow(2, 6, 9);
        box03.grow(10, 10, 10);
    }
}

interface SomeInterface{
    String str = "string";
    static void printString(){
        System.out.println(str);
    }
}


