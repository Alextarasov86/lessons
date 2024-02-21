package lesson05;

import java.text.MessageFormat;
import java.util.Formatter;
import java.util.Locale;

public class Test1 {
    public static void main(String[] args) {
        String item = "Книга";
        int count = 6;
        double rating = 5.5;
        String formattedString =
                MessageFormat.format("Товар: {0}. На складе: {1}шт. Рейтинг: {2}.",
                        item, count, rating);
        System.out.println(formattedString);

        MessageFormat messageFormat = new MessageFormat("Т: {0}." +
                " Кол: {1, choice, 0#товар отсутствует|0<мало|5<много}. Р: {2}.", Locale.UK);
        formattedString = messageFormat.format(new Object[]{item, count, rating});
        System.out.println(formattedString);

        int number = 1;
        boolean answer = true;
        double value = 5.77233;
        formattedString = String.format("%d) Верный ответ: %B", number, answer);
        System.out.println(formattedString);

        StringBuilder stringBuilder = new StringBuilder();
        Formatter formatter = new Formatter(stringBuilder);

        formattedString = formatter.format("%d) Верный ответ: %B", number, answer).toString();
        System.out.println(formattedString);
        stringBuilder.setLength(7);
    }
}
