package ru.alex.project.lesson14;

import ru.alex.project.lesson14.PairContainer;
import ru.alex.project.lesson14.vehicle.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task14 {

    public static <T extends Vehicle, K extends T> K[] task01(T first, K second, Car car){
        // какие методы можно вызвать у second?

        /* Можно вызвать методы Object и Vehicle
        */

        // какие из аргументов можно добавить в массив, а какие нет и почему

        /* Можно добавить second, first и car добавить нельзя, т.к. в массив можно добавлять K и его подтипы,
         а супертипы нельзя
         */
        K[] arr = {};
        return arr;
    }

    public static void main(String[] args) {
        // Задание 1
        // какие типы можно указать в угловых скобках вместо ??? и
        // экземпляры каких классов передать?
        MiniCar miniCar = new MiniCar(Repaintable.Color.BLACK, "1");
        MiniCar miniCar2 = new MiniCar(Repaintable.Color.BLACK, "2");
        Car car = new Car(Repaintable.Color.BLUE, "2");
        Car car2 = new Car(Repaintable.Color.BLUE, "3");
        Train train = new Train("2", 1, true);
        Train train2 = new Train("3", 4, true);
        Bus bus = new Bus("2");
        Bus bus2 = new Bus("3");

        Task14.<Vehicle, Car>task01(bus2, car2, car2); // Можно указывать дочерние классы Vehicle.
        // Передавать можно экземпляры всех транрспортных средств и третий аргумент Сar.
        Task14.<MiniCar, MiniCar >task01(miniCar2, miniCar, car); // Можно указывать Vehicle, Car и MiniCar.
        // Если Vehicle передавать можно экземпляры Car и MiniCar. Если Car, то экз. Car и MiniCar.
        // Если MiniCar, то только MiniCar. Третий аргумент Car.
        Task14.<Train, ???>task01(train2, train, car);  // Можно указывать Train.
        // Передавать экземпляры можно только класса Train и третий аргумент Сar.

        // Задание 2
        // Написать метод, который принимает на вход массив чисел (использовать дженерик)
        // и возвращает PairContainer, где ключи - сумма четных элементов
        // значения - сумма нечетных элементов
    }

    public PairContainer<Integer, Integer> abc(int[] array){
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < array.length; i += 2){
            if(array[i] % 2 == 0) {
                sum1 += array[i];
            } else {
                sum2 += array[i];
            }
        }
        PairContainer<Integer, Integer> pc = new PairContainer<>();
        pc.key = sum1;
        pc.value = sum2;
        return pc;
    }
}