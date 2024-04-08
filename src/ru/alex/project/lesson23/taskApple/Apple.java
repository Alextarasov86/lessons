package ru.alex.project.lesson23.taskApple;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public record Apple(
        long id,
        String color,
        double weight) {
    // color()
    // id()
    // weight()


    public static void main(String[] args) throws IOException {
        Apple apple = new Apple(1, "red", 12);
        AppleFiles appleFiles = new AppleFiles();
//        appleFiles.addApple(apple);
        Apple apple2 = new Apple(2, "green", 10);
//        appleFiles.addApple(apple2);
        List<String> stringList = Files.readAllLines(Paths.get("file.txt"));

        appleFiles.removeApple(apple);
    }
}