package homework;

import java.util.Scanner;

public class Lesson04 {
    public static void main(String[] args) {
        int a = 1;
        int b = 100;
        int middle = (a + b)/ 2;

        while(true){
            System.out.println("Число равно " + middle + " ?");
            Scanner scanner1 = new Scanner(System.in);
            int userInput = scanner1.nextInt();;

            if (userInput == 1){
                System.out.println("Ты угадал");
                break;
            }
            else if(userInput == 0){
                System.out.println("Число больше " + middle + " ?");
                userInput = scanner1.nextInt();
                if(userInput == 0){
                    b = middle;
                    middle = (a + b)/ 2;
                } else if (userInput == 1){
                    a = middle;
                    middle = (a + b)/2;
                    if(middle == a){
                        middle += 1;
                    }
                }
            }
        }
    }
}
