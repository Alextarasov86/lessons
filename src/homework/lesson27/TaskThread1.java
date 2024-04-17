package homework.lesson27;

import ru.alex.project.lesson23.taskApple.Apple;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TaskThread1 {
    public static void checkFile(String path){
        try{
            List<String> stringList = Files.readAllLines(Paths.get(path));
            int count = 0;
            for (String s : stringList) {
                String[] strings = s.split("::");
                if(Integer.parseInt(strings[1]) > 7){
                    System.out.println(strings[2]);
                    count++;
                }
            }
            System.out.println(count);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) throws IOException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                checkFile("file1.txt");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                checkFile("file2.txt");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                checkFile("file3.txt");
            }
        }).start();

        checkFile("file4.txt");
    }
}
