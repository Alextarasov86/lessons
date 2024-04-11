package homework.lesson24;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Task2 {

    public long countSequence(File file, String sequence) {
        try (var lines = Files.lines(Paths.get(file.toURI()), StandardCharsets.UTF_8)) {
            return lines.filter(line -> line.equals(sequence)).count();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Task2 task2 = new Task2();
        File dir1 = new File("file2.txt");
        System.out.println(task2.countSequence(dir1, "dd8222kdd8"));
    }
}
