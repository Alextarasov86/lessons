package lesson05;

import java.util.Arrays;

public class ArrayLesson {
    public static void main(String[] args) {
        int[] temp = {122, 90, 45, -3, 67, -33};
        for(int i = temp.length - 1; i >= 0; i--){
            if(temp[i] < 0){
                temp[i] = 0;
            }
            System.out.println(temp[i]);
        }


        int sum = 0;
        for (int i : temp) {
            sum += i;
        }
        System.out.println(sum);

         String[] colors = {"red", "blue", null, "orange"};
        // String[] newColors = colors;
        // colors -> {"red", "blue", "null", "green"}
//         newColors -> {"red", "blue", "null", "green"};


        String[] newColors01 = colors.clone();
        String[] newColors02 = Arrays.copyOf(colors, 2);
//          String[] colors = {"red", "blue", null, "orange"};
//        String[] newColors03 = new String[colors.length * 2];
        // [null, "red", "blue", null,"orange", null]
//        System.arraycopy(colors, 0, newColors03, 1, 3);

    }
}
