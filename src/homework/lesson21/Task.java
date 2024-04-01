package homework.lesson21;

import java.time.LocalDateTime;
import java.util.Set;

public class Task {
    private int id;
    private String title;
    private Status status;
    private Priority priority;
    private LocalDateTime createdAt;
    private LocalDateTime closeTo;

    public Task(int id, String title) {
        if(id < 1){
            throw new IllegalArgumentException("ID должен быть положительным числом больше 0");
        }
        if(title.length() < 1){
            throw new IllegalArgumentException("Title должен содержать хотя бы один символ");
        }
        this.id = id;
        this.title = title;
        this.createdAt = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public LocalDateTime getCloseTo() {
        return closeTo;
    }

    public Priority getPriority() {
        return priority;
    }

    // геттеры, сеттеры и д.т

    public enum Status{
        NEW, IN_PROGRESS, CLOSED
    }

    public enum Priority{
        URGENT, HIGH, MEDIUM, LOW
    }
}