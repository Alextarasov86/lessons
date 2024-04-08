package ru.alex.project.lesson23.taskApple;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AppleFiles implements Methods<Apple, Long>{
    @Override
    public List<Apple> getApples() throws IOException {
        List<String> stringList = Files.readAllLines(Paths.get("filename.txt"));
        List<Apple> appleList = new ArrayList<>();
        for (String s : stringList) {
            String[] strings = s.split(" ");
            Apple apple = new Apple(Long.parseLong(strings[0]), strings[1], Double.parseDouble(strings[2]));
            appleList.add(apple);
        }
        return appleList;
    }

    @Override
    public Apple getAppleToId(Long id) throws IOException {
        List<String> stringList = Files.readAllLines(Paths.get("filename.txt"));
        Apple apple = null;
        for (String s : stringList) {
            if (s.contains(Long.toString(id))) {
                String[] strings = s.split(" ");
                apple = new Apple(Long.parseLong(strings[0]), strings[1], Double.parseDouble(strings[2]));
            }
        }
        return apple;
    }

    @Override
    public void addApple(Apple apple) throws IOException {

        String s = apple.id() + " " + apple.color() + " " + apple.weight();
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("file.txt", true));
            writer.write(s);
            writer.newLine();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeApple(Apple apple) throws IOException {
        List<String> stringList = Files.readAllLines(Paths.get("file.txt"));
        System.out.println(stringList);
        stringList.removeIf(s -> s.equals(String.valueOf(apple.id()) + " " + apple.color() + " " + String.valueOf(apple.weight())));
        System.out.println(stringList);
        BufferedWriter writer = new BufferedWriter(new FileWriter("file.txt"));
        for (String s : stringList) {
            writer.write(s);
            writer.newLine();
        }
        writer.close();
    }
}
