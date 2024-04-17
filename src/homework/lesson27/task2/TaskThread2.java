package homework.lesson27.task2;

import ru.alex.project.lesson23.taskApple.Apple;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class TaskThread2 implements Runnable{
    private String path;
    private List<Product> productList;

    public TaskThread2(String path) {
        this.path = path;
    }
    @Override
    public void run() {
        List<String> stringList = null;
        try {
            stringList = Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Product product = null;
        for (String s : stringList) {
            String[] strings = s.split("::");
            product = new Product(Integer.parseInt(strings[0]), strings[1],
                    Double.parseDouble(strings[2]), Integer.parseInt(strings[3]));
            productList.add(product);
        }
    }

    public static Map<String, List<Product>> listToMap(List<Product> productList){
        Comparator<Product> byPrice = (p1, p2) -> (int) (p1.getPrice() - p2.getPrice());
        Map<String, List<Product>> map = productList.stream().collect(
                Collectors.groupingBy(Product::getName, Collectors.toCollection(ArrayList::new)));
        for (String s : map.keySet()) {
            List<Product> list = map.get(s);
            list.sort(byPrice);
            map.put(s, list);
        }
        return map;
    }

    public static void main(String[] args) throws InterruptedException {
        TaskThread2 taskThread1 = new TaskThread2("file1.txt");
        TaskThread2 taskThread2 = new TaskThread2("file2.txt");
        TaskThread2 taskThread3 = new TaskThread2("file3.txt");
        TaskThread2 taskThread4 = new TaskThread2("file4.txt");

        Thread myThread1 = new Thread(taskThread1);
        Thread myThread2 = new Thread(taskThread2);
        Thread myThread3 = new Thread(taskThread3);
        Thread myThread4 = new Thread(taskThread4);
        myThread1.start();
        myThread2.start();
        myThread3.start();
        myThread4.start();
        myThread1.join();
        myThread2.join();
        myThread3.join();
        myThread4.join();
        List<Product> productList = new ArrayList<>();
        productList.addAll(taskThread1.productList);
        productList.addAll(taskThread2.productList);
        productList.addAll(taskThread3.productList);
        productList.addAll(taskThread4.productList);
        DaemonThread daemonThread = new DaemonThread(productList);
        daemonThread.setDaemon(true);
        daemonThread.start();
        Map<String, List<Product>> map = listToMap(productList);
    }
}
