package ru.alex.project.lesson18;

import java.util.ArrayList;
import java.util.Map;

public class Test1 {
}

class Student{
    private String id;
    private String name;
    private int age;

    public Student(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

class School{
    private int id;
    private ArrayList<Student> students;

    public School(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}

class SchoolsStat{
    public static int avgAge(Map<Integer, School> schoolsById){
        int countAge = 0;
        int countStudents = 0;
        for (Map.Entry<Integer, School> integerSchoolEntry : schoolsById.entrySet()) {
            for (int i = 0; i < integerSchoolEntry.getValue().getStudents().size(); i++) {
                countAge += integerSchoolEntry.getValue().getStudents().get(i).getAge();
            }
            countStudents += integerSchoolEntry.getValue().getStudents().size();
        }
        return countAge / countStudents;
    }
}