package homework.lesson29;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ThreadTask{
    private String path;
    private List<String> stringList = new ArrayList<>();
    int numberOfThreads = Runtime.getRuntime().availableProcessors();
    Map<String, Long> stringLongMap = new HashMap<>();

    ThreadTask(String path){
        this.path = path;
    }

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

    public void findTopWords(){
        try {
            List<String> strings1 = Files.readAllLines(Paths.get(path));

            for (String s : strings1) {
                List<String> strings2 = new ArrayList<>(List.of(s.split("\\,|\\.|\\;|\\?|\\!|\\ ")));
                stringList.addAll(strings2);
            }

            for (int i = 0; i < stringList.size(); i++) {
                if(stringList.get(i).length() < 3){
                    stringList.remove(stringList.get(i));
                }
            }

            Set<String> set = new HashSet<>(stringList);

            ArrayList<String> stringUniqueList = new ArrayList<>(set);
            for(int i =0; i < numberOfThreads; i++){
                SupportThread supportThread = new SupportThread(stringUniqueList);
                supportThread.start();
                supportThread.join();
            }
            Iterator<Map.Entry<String, Long>> iterator = sortByValue(stringLongMap).entrySet().iterator();
            int c = 0;
            while (iterator.hasNext() && c != 10) {
                Map.Entry<String, Long> entry = iterator.next();
                System.out.println(entry.getKey() +" " + entry.getValue());
                c++;
            }

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private class SupportThread extends Thread{
        List<String> stringUniqueList;
        SupportThread(List<String> stringList){
            this.stringUniqueList = stringList;
        }
        public void run(){
            HashMap<String, Long> map = new HashMap<>();
            if(!stringUniqueList.isEmpty()){
                synchronized (stringUniqueList){
                    for(int i = 0; i < stringUniqueList.size(); i++){
                        long count = 0;
                        for(int j = 0; j < stringList.size(); j++){
                            if(stringUniqueList.get(i).equals(stringList.get(j))){
                                count++;
                            }
                        }
                        map.put(stringUniqueList.get(i), count);
                    }
                    stringUniqueList.remove(0);
                }
            }
            synchronized (stringLongMap){
                stringLongMap.putAll(map);
            }
        }
    }
    public static void main(String[] args) {
        ThreadTask threadTask = new ThreadTask("file.txt");
        threadTask.findTopWords();

    }
}
