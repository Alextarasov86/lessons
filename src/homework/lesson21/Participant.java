package homework.lesson21;

public class Participant {
    private int id;
    private String name;
    // доступен в данный момент
    private boolean active;
    // опыт
    private int experience;
    // максимальное количество задач, которые может выполнить
    private int maxTasks;

    // геттеры, сеттеры и д.т

    public Participant(int id, String name) {
        if(id < 1){
            throw new IllegalArgumentException("ID должен быть положительным числом больше 0");
        }
        if(name.length() < 2){
            throw new IllegalArgumentException("Имя должно содержать больше 1 буквы");
        }
        this.id = id;
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public int getId() {
        return id;
    }
}