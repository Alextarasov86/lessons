package homework;

public class Lesson2HomeWork {
    public static void main(String[] args) {
        // Задание 1
        int numberEmails = 100;
        int sentEmails = 43;
        System.out.println("Осталось отправить " + (numberEmails - sentEmails) + " писем");

        // Задание 2
        double hours = 2.5;
        double kilometers = 150;
        double speed;
        speed = (kilometers * 1000) / (hours * 3600);
        System.out.println("Скорость равна " + speed + " м/с");

        // Задание 3
        int number = 25;
        int firstNumber = number % 10;
        int secondNumber = number / 10;
        int sum = firstNumber + secondNumber;
        System.out.println("Сумма цифр числа " + number + " равна " + sum);

        // Задание 4
        int a = 5;
        int b = 7;
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a = " + a + ", b = " + b);
    }
}
