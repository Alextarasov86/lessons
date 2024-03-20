package ru.alex.project.lesson15;

public class User implements Comparable<User>{
    private int id;
    private String city;
    private int age;

    public User(int id, String city, int age) {
        this.id = id;
        this.city = city;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(User o) {
       if(this.id - o.id == 0){
           if(this.age - o.age == 0){
               return this.city.compareToIgnoreCase(o.city);
           }
           return this.age - o.age;
       }
       return this.id - o.id;
    }
}
