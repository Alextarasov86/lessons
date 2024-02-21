package homework.lesson06;

public class Task4 {
    public static void main(String[] args) {
        int[] task02 = {88, 34, 12, 55, 90, 4, 10, 44};

        int[] subArray = new int[2];
        int sum = 0;

        int target = 94;
        for(int i = 0; i < subArray.length; i++) {
            sum += task02[i];
            if(sum == target) {
                System.out.println(sum);
                for(int k = i; k >= 0; k--){
                    System.out.print(task02[k] + " ");
                }
            }
        }

        for(int j = subArray.length; j < task02.length; j++){
            sum = sum + task02[j] - task02[j - subArray.length];
            if(sum == target){
                int count = subArray.length;
                while (count != 0){
                    System.out.print(task02[j] + " ");
                    j--;
                    count--;
                }
                System.out.println();
                System.out.println(sum);
                break;
            } else
                continue;
        }
        if(sum != target){
            System.out.println("Таких чисел нет");
        }

    }
}
