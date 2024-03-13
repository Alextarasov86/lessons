package ru.alex.project.lesson12;

import java.io.IOException;
import java.util.Scanner;

public class Exceptions {
    public static void readFromFile(String filename) throws IOException{
        if(!filename.endsWith(".json") || !filename.endsWith(".xml")){
            throw new IOException("filename is not valid");
        }
    }

    public static void read(){
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.nextLine();
        try {
            readFromFile(filename);
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
