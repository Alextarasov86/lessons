package homework.myGame2;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {
    static boolean isSave;
    private Paragraph paragraph;

    public void startNewGame() throws IOException {
        showNewParagraph("Лисенок");
    }
    public void returnToGame(){
        try (BufferedReader reader = new BufferedReader(new FileReader("saveCurrent.txt"))) {
            String line = reader.readLine(); // читаем первую строку из файла
            showNewParagraph(line);
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
    public void exit(){
        System.exit(0);
    }
    public void save() throws IOException {
        isSave = true;
        try (BufferedReader reader = new BufferedReader(new FileReader("saveCurrent.txt"))) {
            String line = reader.readLine(); // читаем первую строку из файла
            BufferedWriter writer = new BufferedWriter(new FileWriter("saveGame.txt"));
            writer.write(line);
            writer.close();
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
        Menu.printMenu();
    }
    public void load(){
        try (BufferedReader reader = new BufferedReader(new FileReader("saveGame.txt"))) {
            String line = reader.readLine(); // читаем первую строку из файла
            showNewParagraph(line);
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
    public void returnToMenu() throws IOException {
        Menu.printMenu();
    }

    public void saveCurrentParagraph(String title){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("saveCurrent.txt"));
            System.out.println("фаил записался");
            writer.write(title);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showNewParagraph(String title) throws IOException {
        List<String> stringList = Files.readAllLines(Paths.get("file.txt"));
        Paragraph paragraph = null;
        for (String s : stringList) {
            if (s.startsWith(title)) {
                String[] strings = s.split(";");

                paragraph = new Paragraph(strings[0], strings[1], strings[2], strings[3]);
            }
        }
        System.out.println(paragraph.getText());
        if(!paragraph.getChoice1().equals("0") && !paragraph.getChoice2().equals("0")){
            paragraph.showParagraph();
            if(paragraph.getChoice1().contains("->")){
                int index = paragraph.getChoice1().indexOf('>');
                paragraph.setChoice1(paragraph.getChoice1().substring(index + 1).trim());
            }
            if(paragraph.getChoice2().contains("->")){
                int index = paragraph.getChoice2().indexOf('>');
                paragraph.setChoice2(paragraph.getChoice2().substring(index + 1).trim());
            }
            Scanner scanner = new Scanner(System.in);
            int command;
            command = scanner.nextInt();
            switch (command){
                case 1:
                    saveCurrentParagraph(paragraph.getChoice1());
                    showNewParagraph(paragraph.getChoice1());
                    System.out.println("Случай 1");

                    break;
                case 2:
                    saveCurrentParagraph(paragraph.getChoice2());
                    showNewParagraph(paragraph.getChoice2());
                    System.out.println("Случай 2");

                    break;
                case 3:
                    returnToMenu();
            }
        } else {
            System.exit(0);
        }
    }
}
