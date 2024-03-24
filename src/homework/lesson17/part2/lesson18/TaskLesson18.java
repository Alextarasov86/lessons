package homework.lesson17.part2.lesson18;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class TaskLesson18 {
    public static void main(String[] args) {
        List<Task> taskList = new ArrayList<>();

        // Задание №1
        LocalDateTime now = LocalDateTime.now();
        taskList.removeIf(x -> x.getCreatedAt().plusMonths(1).isBefore(now) && x.getStatus() == Task.Status.CLOSED);

        // Задание №2
        taskList.forEach(x -> {
            if(x.getStatus() == Task.Status.IN_PROGRESS && x.getCloseTo() == now){
                System.out.println(x);
            }
        });

        // Задание №3
        LocalDateTime dayStart = LocalDateTime.of(2024, 2, 1, 8, 30);
        LocalDateTime dayEnd = LocalDateTime.of(2024, 5, 31, 22, 0);
        taskList.forEach(x -> {
            if(x.getCreatedAt().isAfter(dayStart) && x.getCloseTo().isBefore(dayEnd)){
                System.out.println(x);
            }
        });


        Function<List<Task>, List<String>> function = list -> {
            List<Task> list2 = new ArrayList<>();
            List<String> stringList =new ArrayList<>();
            list.forEach(task -> {
                if(task.getStatus() == Task.Status.CLOSED){
                    list2.add(task);
                    Collections.sort(list2);
                    list2.forEach(task1 -> stringList.add(task1.getTitle()));
                }
            });
            return stringList;
        };
    }
}
