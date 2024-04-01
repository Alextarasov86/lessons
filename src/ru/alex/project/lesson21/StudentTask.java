package ru.alex.project.lesson21;

import ru.alex.project.lesson14.vehicle.Car;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class StudentTask {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student(1, "Женя", Student.Gender.MALE, LocalDate.now().minusYears(10)),
                new Student(2, "Олег", Student.Gender.MALE, LocalDate.now().minusYears(7)),
                new Student(3, "Алена", Student.Gender.FEMALE, LocalDate.now().minusYears(6)),
                new Student(4, "Иван", Student.Gender.MALE, LocalDate.now().minusYears(12)),
                new Student(5, "Алексей", Student.Gender.MALE, LocalDate.now().minusYears(9)),
                new Student(6, "Петр", Student.Gender.MALE, LocalDate.now().minusYears(9)),
                new Student(7, "Иван", Student.Gender.MALE, LocalDate.now().minusYears(17)),
                new Student(8, "Петр", Student.Gender.MALE, LocalDate.now().minusYears(5)),
                new Student(9, "Алена", Student.Gender.FEMALE, LocalDate.now().minusYears(8)),
                new Student(10, "Алена", Student.Gender.FEMALE, LocalDate.now().minusYears(10)),
                new Student(11, "Григорий", Student.Gender.MALE, LocalDate.now().minusYears(7)),
                new Student(12, "Ирина", Student.Gender.FEMALE, LocalDate.now().minusYears(6))
        ));

        //  1. Разделить учеников на две группы: мальчиков и девочек.
        //  Результат: Map<Student.Gender, ArrayList<Student>>
        Map<Student.Gender, ArrayList<Student>> map1 = students.stream().collect(Collectors.groupingBy(
                student -> student.getGender(),
                Collectors.toCollection(ArrayList::new)
        ));

        // 2. Найти средний возраст учеников
        Function<Student, Integer> function = student -> LocalDate.now().getYear() - student.getBirth().getYear();
        double avg = students.stream().mapToInt(student -> LocalDate.now().getYear() - student.getBirth().getYear()).average().getAsDouble();
        System.out.println(avg);

        //  3. Найти самого младшего ученика
        Student young = students.stream().max((s1, s2) -> s1.getBirth().getYear() - s2.getBirth().getYear()).get();
        System.out.println(young.getNumber());

        // 4. Собрать идентификаторы в группы по году рождения,
        // результат - Map<ГодРождения, List<Student>>
        Map<Integer, List<Integer>> idsByYear = students.stream()
                .collect(Collectors.groupingBy(
                        student -> student.getBirth().getYear(),
                        // формирует коллекцию объектов String типа из объектов Vehicle типа
                        Collectors.mapping(student -> student.getNumber(), Collectors.toList())
                ));

        // 5. Отсортировать по полу, потом по дате рождения,
        // потом по имени (в обратном порядке), собрать в список (ArrayList)
        Comparator<Student> bySex = (s1, s2) -> s1.getGender().ordinal() - s2.getGender().ordinal();
        Comparator<Student> byBirth = (s1, s2) -> s1.getBirth().compareTo(s2.getBirth());
        Comparator<Student> byName = (s1, s2) -> s1.getName().compareTo(s2.getName());
        Comparator<Student> byNameReverse = byName.reversed();
        Comparator<Student> comparator = bySex.thenComparing(byBirth).thenComparing(byNameReverse);
        Collections.sort(students, comparator); // Вариант 1
        students.stream().sorted(comparator); // Вариант2

        // 6. Вывести в консоль всех учеников в возрасте от N до M лет
    }
}