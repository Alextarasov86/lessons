package homework;

public class Lesson03 {
    public static void main(String[] args) {
        // Задание 1
        int a = 10;
        int b = 500;
        int randomNumber = a + (int) (Math.random() * b);
        if(randomNumber >= 25 && randomNumber <= 200){
            System.out.println("Число " + randomNumber + " содержится в интервале (25; 200)");
        } else {
            System.out.println("Число " + randomNumber + " не содержится в интервале (25; 200)");
        }

        // Задание 2
        int x = -12;
        int y = 6;
        if ( x > 0 && y > 0){
            System.out.println("Точка принадлежит первой четверти");
        } else if (x < 0 && y > 0){
            System.out.println("Точка принадлежит второй четверти");
        } else if (x < 0 && y < 0){
            System.out.println("Точка принадлежит третьей четверти");
        } else if (x > 0 && y < 0){
            System.out.println("Точка принадлежит четвертой четверти");
        } else {
            System.out.println("Точка не принадалежит ни одной из четвертей");
        }

        // Задание 3
        int monthNumber = 2;
        boolean isLeap = false;

        switch (monthNumber){
            case 1, 3, 5, 7, 8, 10, 12 -> System.out.println("В этом месяце 31 день");
            case 4, 6, 9, 11 -> System.out.println("В этом меяце 30 дней");
            case 2 -> {
                if(isLeap){
                    System.out.println("В этом месяце 29 дней");
                } else {
                    System.out.println("В этом месяце 28 дней");
                }
            }
        }
        // Задание 4
        int couponNumber = 5550;
        double resultSum = 3598;
        switch (couponNumber){
            case 1111, 4444, 9999 -> {
                resultSum = resultSum - (resultSum / 100) * 10 ;
            }
            case 3333, 7777 -> {
                resultSum = resultSum -(resultSum / 100) * 20;
            }
            case 5555 -> {
                resultSum = resultSum - (resultSum / 100) * 30;
            }
        }
        System.out.println(resultSum);

    }
}
