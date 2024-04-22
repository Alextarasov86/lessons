package homework.myGame2;

import ru.alex.project.lesson23.taskApple.Apple;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParagraphStorage {
    List<Paragraph> paragraphList = new ArrayList<>();
    String text1 = "Каждое утро Лисёнок просыпался, завтракал и шёл увидеться с Бельчонком."+
            "Это утро не было исключением. Лисёнок пришёл на их обычное место встречи," +
            "но Бельчонка там не было. Лисёнок ждал, ждал, но так и не смог дождаться своего друга." +
            "\"Бельчонок не пропустил еще ни одной встречи, вдруг он попал в беду.\"" +
            "- подумал Лисёнок. Как поступить Лисенку?";
    String choice1 = "Вернуться домой";
    String choice2 ="Отправиться на поиски";
    Paragraph paragraph1 = new Paragraph("Лисенок", text1, choice1, choice2);

    public static void addApple(Paragraph paragraph) throws IOException {

        String s =paragraph.getTitle() + ";" + paragraph.getText() + ";" + paragraph.getChoice1() + ";" + paragraph.getChoice2();
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter("file.txt", true));
            writer.write(s);
            writer.newLine();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Paragraph createParagraphToId(String title) throws IOException {
        List<String> stringList = Files.readAllLines(Paths.get("file.txt"));
        Paragraph paragraph = null;
        for (String s : stringList) {
            if (s.startsWith(title)) {
                String[] strings = s.split(";");
                System.out.println(Arrays.toString(strings));
                paragraph = new Paragraph(strings[0], strings[1], strings[2], strings[3]);
            }
        }
        return paragraph;
    }

    public static void main(String[] args) throws IOException {
        String text1 = "Каждое утро Лисёнок просыпался, завтракал и шёл увидеться с Бельчонком." +
                "Это утро не было исключением. Лисёнок пришёл на их обычное место встречи," +
                "но Бельчонка там не было. Лисёнок ждал, ждал, но так и не смог дождаться своего друга." +
                "\"Бельчонок не пропустил еще ни одной встречи, вдруг он попал в беду.\"" +
                "- подумал Лисёнок. Как поступить Лисенку?";
        String choice1 = "Вернуться домой";
        String choice2 ="Отправиться на поиски";
        String text2 = "Вернувшись домой, Лисёнок нашёл там Бельчонка. Оказалось, что Бельчонок пришёл" +
                "на место встречи раньше и увидел там рой злобных пчел. Он поспешил предупредить об этом Лисёнка," +
                "но они разминулись. Наконец-то друзья нашли друг друга! Игра завершилась успехом";
        Paragraph paragraph2 = new Paragraph( "Вернуться домой", text2, "0", "0");
        Paragraph paragraph1 = new Paragraph("Лисенок", text1, choice1, choice2);
//        addApple(paragraph2);


//        Paragraph paragraph = createParagraphToId("Вернуться домой");
//        System.out.println(paragraph.toString());
    }
}
