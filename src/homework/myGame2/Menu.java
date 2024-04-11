package homework.myGame2;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {

    Paragraph paragraph;

    public void startNewGame(){
        String text1 = "Каждое утро Лисёнок просыпался, завтракал и шёл увидеться с Бельчонком."+
                "Это утро не было исключением. Лисёнок пришёл на их обычное место встречи," +
                "но Бельчонка там не было. Лисёнок ждал, ждал, но так и не смог дождаться своего друга." +
                "\"Бельчонок не пропустил еще ни одной встречи, вдруг он попал в беду.\"" +
                "- подумал Лисёнок. Как поступить Лисенку?";
        String choice = "1. Вернуться домой " +
                "2. Отправиться на поиски";
        paragraph = new Paragraph(1,"Лисенок", text1, choice);
        paragraph.showParagraph();

        Scanner scanner = new Scanner(System.in);
        int command;
        command = scanner.nextInt();

    }
    public void returnToGame(){
        System.out.println("Вы вернулись в игру");
    }
    public void exit(){
        System.out.println("Выход из игры");
    }
    public void save(){
        System.out.println("Вы сохранили игру");
    }
    public void load(){
        System.out.println("Вы загрузили игру");
    }
    public void returnToMenu(){
        System.out.println("Вы вернулись в главное меню");
    }
    public void choice(){
        System.out.println("Вы сделали выбор");
    }

    public static Paragraph createParagraphToId(int id) throws IOException {
        List<String> stringList = Files.readAllLines(Paths.get("file.txt"));
        Paragraph paragraph = null;
        for (String s : stringList) {
            if (s.startsWith(Integer.toString(id))) {
                String[] strings = s.split(";");
                System.out.println(Arrays.toString(strings));
                paragraph = new Paragraph(Integer.parseInt(strings[0]), strings[1], strings[2], strings[3]);
            }
        }
        return paragraph;
    }
}
