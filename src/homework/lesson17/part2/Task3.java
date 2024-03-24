package homework.lesson17.part2;

import ru.alex.project.lesson14.vehicle.Repairable;
import ru.alex.project.lesson14.vehicle.Vehicle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task3 {
    public static Map<String, Vehicle> createRepairedMap(List<Repairable> repairableList){
        Map<String, Vehicle> map = new HashMap<>();
        for (Repairable repairable : repairableList) {
            repairable.repair();
            map.put(((Vehicle)repairable).getNumber(), (Vehicle)repairable);
        }
        return map;
    }
}
