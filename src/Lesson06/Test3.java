package Lesson06;

import java.util.Arrays;

public class Test3 {
    public static void main(String[] args) {
        String s1 = "asdfga";
        String s2 = "safagd";

        char [] ch1 = s1.toCharArray();
        char [] ch2 = s2.toCharArray();

        for (int i = 0; i < ch1.length; i++){
            for (int j = 0; j < ch1.length; j++){
                if(ch1[i] > ch1[j]){
                    char ch3 = ch1[j];
                    ch1[j] = ch1[i];
                    ch1[i] = ch3;
                }
            }
        }

        for (int i = 0; i < ch2.length; i++){
            for (int j = 0; j < ch2.length; j++){
                if(ch2[i] > ch2[j]){
                    char ch3 = ch2[j];
                    ch2[j] = ch2[i];
                    ch2[i] = ch3;
                }
            }
        }
        System.out.println(Arrays.toString(ch1));
        System.out.println(Arrays.toString(ch2));
        System.out.println(new String(ch1).equals(new String(ch2)));

    }
}
