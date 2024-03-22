package homework.lesson17;

import java.util.*;

public class Task1 {
    public static Map<String,Long> findWords(Collection<String> strings){
        Map<String, Long> map = new HashMap<>();
        ArrayList<String> arrayStrings1 = new ArrayList<>(strings);
        Set<String> setStrings = new HashSet<>(strings);
        ArrayList<String> arrayStrings2 = new ArrayList<>(setStrings);

        for(int i = 0; i < arrayStrings2.size(); i++){
            long count = 0;
            for(int j = 0; j < arrayStrings1.size(); j++){
                if(arrayStrings2.get(i) != null && arrayStrings1.get(j) != null){
                    if(arrayStrings2.get(i).equals(arrayStrings1.get(j))){
                        count++;
                    }
                }
            }
            map.put(arrayStrings2.get(i), count);
            count = 0;
        }
        return map;
    }
}
