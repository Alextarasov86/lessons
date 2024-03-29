package homework.lesson20;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) {
        Author author1 = new Author("Oleg", "oleg@mail.ru", LocalDate.of(1985, 12, 23));
        Author author2 = new Author("Dmitriy", "dmitriy@mail.ru", LocalDate.of(1970, 1, 2));
        Author author3 = new Author("Mariya", "mariya@mail.ru", LocalDate.of(1975, 2, 3));
        Author author4 = new Author("Ivan", "ivan@mail.ru", LocalDate.of(1980, 10, 9));
        Author author5 = new Author("Ivan", "ivan2@mail.ru", LocalDate.of(1988, 8, 29));
        Author[] authors1 = {author1, author5, author2};
        Author[] authors2 = {author1, author5, author2, author4, author3};
        int[] a = {1,2,3,4};
        int[] b = {1,2,3};
        boolean test=true;
        //массивы просто для примера чтоб их имена использовать
//        for (int i = 0; i < a.length; i++){
//
//            int finalI = i;
//            if(Arrays.stream(b).allMatch(x -> x == a[finalI])){
//                test = false;
//                System.out.println("Содержит не все элементы");
//                break;}
//        }
    }
}

class A {
    LocalDateTime published;

    public LocalDateTime getPublished() {
        return published;
    }

    public static void main(String[] args) {
        A a = new A();
        a.published = LocalDateTime.of(2024, 3, 28, 8, 22, 12);

        LocalDate ld = LocalDate.of(a.published.getYear(), a.published.getMonth(), a.published.getDayOfMonth());
        System.out.println(ld.equals(LocalDate.now()));
    }


}
