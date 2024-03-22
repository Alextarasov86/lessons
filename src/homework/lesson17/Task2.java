package homework.lesson17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Task2 {
    public static Map<String, Long> findWord(String word, String text){
        ArrayList<String> strings = new ArrayList<>(List.of(text.split(" ")));
        Map<String, Long> map = new HashMap<>();
        long count = 0;
        for (int i = 0; i < strings.size(); i++) {
            if(word != null){
                if(word.equals(strings.get(i))){
                    count++;
                }
            }
        }
        map.put(word, count);
        return map;
    }
}
