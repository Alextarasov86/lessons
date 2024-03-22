package homework.lesson17;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task3 {
    public static Map<Integer, List<String>> findLetters(String text){
        ArrayList<String> strings = new ArrayList<>(List.of(text.split(" ")));
        Map<Integer, List<String>> map = new HashMap<>();
        for(int i = 0; i < strings.size(); i++){
            map.put(strings.get(i).length(), new ArrayList<>());
        }
        for(int i = 0; i < strings.size(); i++){
            map.get(strings.get(i).length()).add(strings.get(i));
        }
        return map;
    }
}
