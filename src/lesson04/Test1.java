package lesson04;

public class Test1 {
    public static void main(String[] args) {
        int x = 3;
        int degree = 5;
        int res = 1;
        while(degree > 0){
            res = res * x;
            degree -= 1;

        }
        System.out.println(res);

        for(int i = 1; i <= 10; i++){
            System.out.println(i * 2);
        }

        for(int i = 1; i <= 6; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }
}
