package Lesson06;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
//        String s1 = "asdaadsa";
//        StringBuilder s2 = new StringBuilder(s1);
//        StringBuilder s3 = s2.reverse();
//        System.out.println(s1.equals(s3.toString()));

//        int [] arr1 = new int[5];
//        int [] arr2 = new int[5];
//        int index1 = 0;
//        int index2 = 0;



        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String s1 = input.trim().toLowerCase();
        System.out.println(s1.substring(0, 1).toUpperCase() + s1.substring(1));;


    }

}
