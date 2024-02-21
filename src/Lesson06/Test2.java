package Lesson06;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        int [] arr1 = new int[5];
        int [] arr2 = new int[5];
        int index1 = 0;
        int index2 = 0;
        Scanner sc = new Scanner(System.in);
        while(arr1[arr1.length - 1] == 0 || arr2[arr2.length - 1] == 0){
            System.out.println("введите число");
            int input = sc.nextInt();
            if(input == 0) {
                break;
            }
            if(input < 0){
                arr1[index1] = input;
                index1++;
            } else if(input > 0){
                arr2[index2] = input;
                index2++;
            }
        }
        System.out.println(arr1.toString());
        System.out.println(arr2.toString());
    }
}
