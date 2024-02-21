package Lesson06;

public class Test4 {
    public static void main(String[] args) {
        int[]x = {88, 34, 12, 55, 90, 4, 4, 34, 4, 12, 10, 44};
        System.out.println(uniqueCount(x));
    }
    public static int uniqueCount(int[]array){

        int[] copy = new int[array.length];
        int res = 0;
        int countNum = 0;
        int count = 0;

        for (int i = 0; i <copy.length ; i++) {
            copy[i] = 0;
        }

        for (int i = 0; i < array.length; i++) {
            if (copy[i]==0){
                for (int j = 0; j < array.length; j++) {
                    if (array[i]==array[j]){
                        copy[j] = 1;
                        count++;
                    }
                }
            }
            if (countNum<count){
                countNum = count;
                res++;
            }

        }
        return res;
    }
}
