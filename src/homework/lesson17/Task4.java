package homework.lesson17;

import java.util.*;

public class Task4 {
    public static <K, V extends Comparable<? super V>> Map<K, V>
    sortByValue(Map<K, V> map ){
        List<Map.Entry<K, V>> list =
                new LinkedList<>(map.entrySet());
        Collections.sort( list, new Comparator<Map.Entry<K, V>>(){
            @Override
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2){
                return (o2.getValue()).compareTo(o1.getValue());
            }
        } );

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list){
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
    public static void findRepeatedWords(String text){
        ArrayList<String> strings = new ArrayList<>(List.of(text.split(" ")));

        Set<String> set = new HashSet<>(strings);
        ArrayList<String> strings2 = new ArrayList<>(set);
        HashMap<String, Long> map = new HashMap<>();

        for(int i = 0; i < strings2.size(); i++){
            long count = 0;
            if(strings2.get(i).length() > 2 &&
                    !strings2.get(i).equalsIgnoreCase("the") &&
                    !strings2.get(i).equalsIgnoreCase("and")){
                for(int j = 0; j < strings.size(); j++){
                    if(strings2.get(i).equals(strings.get(j))){
                        count++;
                    }
                }
                map.put(strings2.get(i), count);
            }
        }



        Iterator<Map.Entry<String, Long>> iterator = sortByValue(map).entrySet().iterator();
        int c = 0;
        while (iterator.hasNext() && c != 10) {
            Map.Entry<String, Long> entry = iterator.next();
            System.out.println(entry.getKey());
            c++;
        }

    }

    public static void main(String[] args) {
        String text = "It is a uncover long established fact that a reader will be distracted uncover by the readable content of a page " +
                "when looking at its layout The point of using uncover Lorem Ipsum is that sites it has a more-or-less normal distribution of letters" +
                "as uncover opposed to still using Content here humour uncover content here making it look like readable English Many desktop publishing " +
                "packages and web page editors now use Lorem Ipsum as their default model text and a search for lorem ipsum will " +
                "uncover many web sites still uncover in their infancy Various versions uncover have evolved over the years uncover sometimes by accident" +
                " sometimes on purpose injected humour and the like";
        findRepeatedWords(text);
    }
}
