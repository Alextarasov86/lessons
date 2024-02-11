package lesson03;

public class Operators {
    public static void main(String[] args) {
        int books = 30, students = 22;
        boolean result = books < students; // false
        result = books == students; // false
        result = books != students; // true
        // books < students < 10019:11

        int sum = 1553;
        double resSum = sum > 1000 ? sum - (double)sum / 10 : sum;
        System.out.println(resSum);

        int a = 8, b = 16, c = 17;
        int res;

        if (a > b){
            res = a;
        } else {
            res = b;
        }
        if(c > res){
            res = c;
        }
        System.out.println(res);

        int currentScoreValue = 89;
        if (currentScoreValue >= 90){
            System.out.println("Первое место");
        } else if (80 < currentScoreValue && currentScoreValue <= 89) {
            System.out.println("Второе место");
        } else {
            System.out.println("Ты проиграл");
        }


        // начиная с java 14 можно использовать новый синтаксис switch
        // в стиле лямбда выражений (lambda style)
        int monthNumber = 6;
        switch(monthNumber) {
            case 12, 1, 2 -> System.out.println("Зима"); // monthNumber не равен 12, не равен 1, не равен 2
            case 3, 4, 5 -> System.out.println("Весна"); // monthNumber не равен 3, не равен 4, не равен 5
            case 6, 7, 8 -> System.out.println("Лето"); // инструкции выполнятся, monthNumber равен 6, switch завершит работу
            case 9, 10, 11 -> System.out.println("Осень");
            // default -> System.out.println("неверный ввод"); - необязательный блок
        }

        char seasonLetter = switch(monthNumber) {
            case 12, 1, 2 -> 'з'; // monthNumber не равен 12, не равен 1, не равен 2
            case 3, 4, 5 -> 'в'; // monthNumber не равен 3, не равен 4, не равен 5
            case 6, 7, 8 -> 'л'; // инструкции выполнятся, monthNumber равен 6, switch вернёт 'л' и завершит работу
            case 9, 10, 11 -> 'о';
            default -> 'e'; // обязательный блок
        };
        System.out.println(seasonLetter);

        seasonLetter = switch(monthNumber) {
            case 12, 1, 2 -> {
                System.out.println("Зима");
                yield 'з';
            }
            case 3, 4, 5 -> {
                System.out.println("Весна");
                yield 'в';
            }
            case 6, 7, 8 -> {
                System.out.println("Лето");
                yield 'л';
            }
            case 9, 10, 11 -> {
                System.out.println("Осень");
                yield 'о';
            }
            default -> { // обязательный блок
                System.out.println("неверный ввод");
                yield  'e';
            }
        };
        System.out.println(seasonLetter);

        int florNumber = 9;
        switch (florNumber){
            case 1, 2 -> System.out.println("7 квартир");
            case 3, 4 -> System.out.println("5 квартир");
            case 5 -> System.out.println("2 квартиры");
            default -> System.out.println("Такого этажа нет");
        }
    }
}
