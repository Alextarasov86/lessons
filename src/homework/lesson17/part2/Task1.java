package homework.lesson17.part2;

import ru.alex.project.lesson14.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Task1 {
    public static List<Vehicle> findLevelOfWare(Map<Integer, Vehicle> map, int levelOfWare){
        List<Vehicle> list = new ArrayList<>();
        for (Vehicle value : map.values()) {
            if(value != null){
                if(value.getLevelOfWare() < levelOfWare){
                    list.add(value);
                }
            }
        }
        return list;
    }
}
