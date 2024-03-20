package ru.alex.project.lesson15;

import ru.alex.project.lesson14.vehicle.Vehicle;

import java.util.Comparator;

public class VehicleComparators {
    public static class LevelOfComparator implements Comparator<Vehicle> {

        @Override
        public int compare(Vehicle o1, Vehicle o2) {
            return -(o1.getLevelOfWare() - o2.getLevelOfWare());

        }
    }
    public static class NumberComparator implements Comparator<Vehicle>{

        @Override
        public int compare(Vehicle o1, Vehicle o2) {
            return o1.getNumber().compareToIgnoreCase(o2.getNumber());
        }
    }
}
