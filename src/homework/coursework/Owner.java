package homework.coursework;

import java.time.LocalDate;

public class Owner {
    private String name;
    private String surname;
    private int yearOfBirth;

    public Owner(String name, String surname, int yearOfBirth){
        if(name.length() < 1){
            throw new IllegalArgumentException("Имя должно содержать больше одной буквы");
        }
        if(surname.length() < 1){
            throw new IllegalArgumentException("Фамилия должна содержать больше одной буквы");
        }
        if(yearOfBirth < 1920 || yearOfBirth > LocalDate.now().getYear()){
            throw new IllegalArgumentException("Вы указали некорректный год рождения");
        }

        this.name = name;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                '}';
    }
}
