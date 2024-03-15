package ru.alex.project.lesson14;

public class PairContainer<T, K> {
    T key;
    K value;

    public static void main(String[] args) {
        PairContainer<String, User<Number>>  pk = new PairContainer<>();
    }
}
