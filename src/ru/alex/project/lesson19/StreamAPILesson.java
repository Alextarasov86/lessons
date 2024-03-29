package ru.alex.project.lesson19;

import ru.alex.project.lesson14.vehicle.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPILesson {
    public static void main(String[] args) {
        Stream<Integer> temps =
                Stream.of(-560, 312, 12, -55, -100, 45, 0, 0, 23, -20, 221);
        temps.filter(x -> x < 0).map(integer -> integer + " deg").forEach(i -> System.out.println(i));

        Stream<Integer> values = Stream.of(-560, 312, 12,
                -55, -100, 45, 0, 0, 23, -20, 221);
        values.distinct().map(integer -> {
            if(integer < 0) return 0;
            return integer;
                }).
                sorted(Comparator.naturalOrder()).forEach(i -> System.out.println(i));

        String[] colors = {"white", "black", "red", "yellow", "yellowgreen", "green", "dark yellow"};
        long count = Arrays.stream(colors).filter(str -> !str.contains("yellow")).count();

        List<Repaintable> repaintables = List.of(
                new Car(Repaintable.Color.GOLD, "001"),
                new MiniCar(Repaintable.Color.BLACK, "002"),
                new MiniCar(Repaintable.Color.ORANGE, "003"),
                new Car(Repaintable.Color.RED, "004"),
                new MiniCar(Repaintable.Color.BLUE, "005"),
                new Car(Repaintable.Color.BLACK, "006"),
                new Car(Repaintable.Color.ORANGE, "007")

        );
        List<Repaintable.Color> list = repaintables.stream().map(repaintable -> repaintable.getColor()).distinct().toList();

        List<Vehicle> vehicles = List.of(
                new Car(Repaintable.Color.GOLD, "001"),
                new Train("002", 10, true),
                new MiniCar(Repaintable.Color.ORANGE, "003"),
                new Bus("004"),
                new Train("005", 15, false),
                new Car(Repaintable.Color.BLACK, "006"),
                new MiniCar(Repaintable.Color.ORANGE, "007")
        );
        vehicles.stream().peek(v -> v.repair()).map(vehicle -> vehicle.getLevelOfWare()).forEach(l -> System.out.println(l));

        // Optional<Vehicle>
        // vehicles.stream().findFirst();
        // vehicles.stream().findAny();

        // vehicles.parallelStream().findFirst();
        // vehicles.parallelStream().findAny();

        // vehicles.stream().forEach();
        // vehicles.stream().forEachOrdered();

        // vehicles.parallelStream().forEach();
        // vehicles.parallelStream().forEachOrdered();

        // vehicles.stream()
        //   .min((o1, o2) -> o1.getLevelOfWare() - o2.getLevelOfWare()); // Optional<Vehicle>
        // vehicles.stream()
        //   .max((o1, o2) -> o1.getLevelOfWare() - o2.getLevelOfWare()); // Optional<Vehicle>

        // true / false
        // vehicles.stream()
        //   .allMatch(vehicle -> vehicle.getLevelOfWare() > 100);
        // vehicles.stream()
        //   .anyMatch(vehicle -> vehicle.getLevelOfWare() > 100);
        // vehicles.stream()
        //   .noneMatch(vehicle -> vehicle.getLevelOfWare() > 100);

        List<List<Integer>> integers = new ArrayList<>();
        integers.add(List.of(3, 5, 8, 1, 9));
        integers.add(List.of(34, -5, 10, 56, 11));
        integers.add(List.of(90, 5, 22, -83, 27));
        integers.stream().mapToInt(value -> value.stream().mapToInt(integer -> integer).sum()).sum();

        // Элементы вложенных stream объединяет в общий stream
        integers.stream().flatMapToInt(list1 -> list1.stream().mapToInt(value -> value));

        // Элементы вложенных stream остаются во вложенных stream
        integers.stream().map(list2 -> list2.stream().mapToInt(value -> value));

        // преобразование stream в массив
        Object[] objectsArr = vehicles.stream().toArray();
        Vehicle[] vehiclesArr = vehicles.stream()
                .toArray(Vehicle[]::new); // ссылка на конструктор массива типа Vehicle
        // IntFunction<A[]> generator R apply(int value);
        // .toArray(size -> new Vehicle[size]); без ссылки на конструктор

        // преобразование stream в список
        List<Vehicle> vehiclesList01 = vehicles.stream()
                .toList(); // unmodifiableList

        List<Vehicle> vehiclesList02 = vehicles.stream()
                .collect(Collectors.toList());// ???List

        List<Vehicle> vehiclesList03 = vehicles.stream()
                .collect(Collectors.toCollection(ArrayList::new));

        String[] strings = {"white", "black", "red", "yellow", "yellowgreen", "green", "dark yellow"};
        Map<String, Integer> stringIntegerMap = Arrays.stream(strings).collect(Collectors.toMap(
                color -> color, // Правила формирования ключей
                color -> color.length(), // правила формирования значений
                (value1, value2) -> value1 + value2 // Что делать со значениями если ключи одинаковые
        ));

        Map<String, Integer> numberLevelOfWare = vehicles.stream().collect(Collectors.toMap(
                vehicle -> vehicle.getNumber(),
                vehicle -> vehicle.getLevelOfWare()
        ));

    }
}
