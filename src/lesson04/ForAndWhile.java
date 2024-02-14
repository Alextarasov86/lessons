package lesson04;

import java.util.Scanner;

public class ForAndWhile {
    public static void main(String[] args) {
//        // WHILE / DO WHILE / FOR
//
//        // I. Цикл WHILE позволяет выполнять последовательность действий,
//        //  пока проверяемое условие истинно. Условие всегда проверяется до тела цикла.
//        //  Чаще используется, когда число итераций (повторений) неизвестно
//        /*
//        while (логическое выражение / условие) {
//            тело цикла - инструкции, которые необходимо выполнять,
//            пока 'условие' истинно
//        }
//        */
//
//        // Пользователь вводит положительные целые числа.
//        // Нужно найти их сумму.
//        Scanner scanner01 = new Scanner(System.in);
//        System.out.println("Вводите положительные целые числа");
//        int userInput;
//        int sum = 0;
//        int count = 0;
//        double average = 0;
//        int max = 0;
//
//        while (scanner01.hasNextInt() && (userInput = scanner01.nextInt()) > 0) {
//            sum += userInput;
//            count += 1;
//
//            if(max < scanner01.nextInt()){
//                max = scanner01.nextInt();
//            }
//        }
//        average = (double)sum / count;
//        System.out.println(sum);
//        System.out.println(count);
//        System.out.println(max);
//        System.out.println(average);
//
//
//        Scanner scanner02 = new Scanner(System.in);
//        while (true) {
//            System.out.println("Введите целое положительное число или " +
//                    "0 для выхода из программы");
//            userInput = scanner02.nextInt();
//            if (userInput == 0) { // если пользователь введет 0
//                break; // выход из текущего цикла
//            }
//            if (userInput < 0) { // если пользователь введет отрицательное число
//                continue; // переход на следующую итерацию к проверке условия
//                // в круглых скобках
//            }
//            // инструкции будут выполнены,
//            // если пользователь введет положительное число
//            System.out.println(userInput * userInput);
//        }

        int a = 0;
        int b = 9;
        int userInput;
        int randomNumber = a + (int) (Math.random() * b);

        while (true){
            Scanner scanner03 = new Scanner(System.in);
            System.out.println("Угадайте число от 0 до 9 ");
            userInput = scanner03.nextInt();
            if (userInput == randomNumber){
                System.out.println("Вы угадали");
                break;
            }if (userInput == -1){
                System.out.println("Выход из программы");
                break;
            }if (userInput > randomNumber){
                System.out.println("Загаданное число меньше");
                continue;
            }if (userInput < randomNumber){
                System.out.println("Загаданное число больше");
                continue;
            }
        }


    }
}
