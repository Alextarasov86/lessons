package homework.lesson06;

import java.util.Arrays;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        String [] array = new String[5];
        Scanner sc = new Scanner(System.in);
        int index = 0;
        while(index < array.length){
            System.out.println("введите строку");
            String input = sc.nextLine();
            boolean found = false;

            for (String s : array) {
                if(input.equals(s)){
                    found = true;
                    break;
                }
            }
            if(!found){
                array[index] = input;
                index++;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
