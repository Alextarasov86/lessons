package homework.lesson17.part2;

import ru.alex.project.lesson14.vehicle.Repaintable;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class Task2 {
    public void createMap(List<Repaintable> repaintableList, EnumMap<Repaintable.Color, List<Repaintable>> map){
        for (Repaintable repaintable : repaintableList) {
            if(!map.containsKey(repaintable.getColor())){
                ArrayList<Repaintable> list = new ArrayList<>();
                list.add(repaintable);
                map.put(repaintable.getColor(), list);
            } else {
               map.get(repaintable.getColor()).add(repaintable);
            }
        }
    }
}
