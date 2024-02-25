package homework;

public class Lesson05 {
    public static void main(String[] args) {
        int[] task02 = {88, 34, 12, 55, 90, 4, 10, 44};
        int subArrayLength = 4;
        int sum = 0;
        int maxSum = 0;
        for(int i = 0; i < subArrayLength; i++){
            sum += task02[i];
            maxSum = sum;
        }
        for(int j = subArrayLength; j < task02.length; j++){
            sum = sum + task02[j] - task02[j - subArrayLength];
            if(sum > maxSum){
                maxSum = sum;
            }
        }
        System.out.println(maxSum);

    }
}
