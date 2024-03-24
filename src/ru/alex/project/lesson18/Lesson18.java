package ru.alex.project.lesson18;
import java.util.function.Function;
import java.util.function.Predicate;

public class Lesson18 {
    public static void main(String[] args) {
        Operation plus1 = (first, second) -> first + second;
        Operation plus2 = (first, second) -> {
            System.out.println(first + second);
            return first + second;
        };
        Operation plus3 = (first, second) -> first - second;
        Operation plus4 = (first, second) -> {
            if(second == 0) throw new IllegalArgumentException("Делить на ноль нельзя");
            return first / second;
        };

        Function<Integer, String> function = number -> number.toString() + " руб.";
        Predicate<Integer> test = number -> number > 0;

}}
