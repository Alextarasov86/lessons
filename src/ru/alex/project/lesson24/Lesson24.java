package ru.alex.project.lesson24;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lesson24 {
    public static void main(String[] args){
        Resource resource =new Resource();

        try{
            resource.resourceVoid();
        } catch (IOException e){
            System.out.println(e.getMessage());;
        }
        finally {
            resource.close();
        }
        try(Resource resource1 = new Resource()) {
            resource1.resourceVoid();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void copyFile(List<String> list, String fileName){
        Map<String, Integer> map = new HashMap<>();
        try {
            List<String> stringList = Files.readAllLines(Paths.get(fileName));
            for (String s : list) {
                int count = 0;
                for (String s1 : stringList) {
                    if(s.equals(s1)){
                        count++;
                        map.put(s, count);
                    }
                }
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter("file.txt", true));
            for (String s : stringList) {
                writer.write(s);
                writer.newLine();
                writer.close();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        System.out.println(map);
    }
}

