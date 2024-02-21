package homework.lesson06;

import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        int[] task02 = {88, 34, 12, 55, 90, 4, 10, 44};
        for(int i = 0; i < task02.length; i++){
            for(int j = 0; j < task02.length; j++){
                if(task02[i] < task02[j]){
                    int k = task02[i];
                    task02[i] = task02[j];
                    task02[j] = k;
                }
            }
        }
        System.out.println(Arrays.toString(task02));
    }
}
