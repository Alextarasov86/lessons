package ru.alex.project.lesson15;

import ru.alex.project.lesson14.vehicle.Car;
import ru.alex.project.lesson14.vehicle.Train;
import ru.alex.project.lesson14.vehicle.Vehicle;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();

        String[] cities = {"Спб", "Москва"};
        List<String> strings = Arrays.asList(cities);

        LinkedList<String> linkedList = new LinkedList<>(strings);
        linkedList.add("Тверь");
        linkedList.add("Спб");

        HashSet<String> hashSet = new HashSet<>(linkedList);

        arrayList.removeIf(e->"Тверь".equals(e));

        for (String s: arrayList){
            System.out.println(s);
        }

        Iterator<String> stringIterator = arrayList.iterator();
        while (stringIterator.hasNext()){
            String el = stringIterator.next();
            System.out.println(el.toUpperCase());
        }

        ArrayList<Vehicle> vehicles;
        List<Car> cars;
        HashSet<Train> trains;

        TreeSet<String> treeSet = new TreeSet<>();
        for (int i = 0; i < arrayList.size(); i++){
            if(arrayList.get(i) != null){
                treeSet.add(arrayList.get(i));
            }
        }

        Comparator<Vehicle> levelOfComparator = new VehicleComparators.LevelOfComparator();
        Comparator<Vehicle> numberComparator = new VehicleComparators.NumberComparator();

        Comparator<Vehicle> vehicleComparatorReverse = levelOfComparator.reversed();
        Comparator<Vehicle> levelOfWareAndNumberComparator = levelOfComparator.thenComparing(numberComparator);

        TreeSet<Vehicle> vehicleTreeSet1 = new TreeSet<>(numberComparator);
    }
}
