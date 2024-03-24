package homework.lesson17.part2.lesson18;

import java.time.LocalDateTime;

public class Task implements Comparable<Task>{
    private int id;
    private String title;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime closeTo;

    // геттеры, сеттеры и д.т

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Status getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getCloseTo() {
        return closeTo;
    }

    @Override
    public int compareTo(Task o) {
        return this.getCloseTo().compareTo(o.getCloseTo());
    }

    public enum Status{
        NEW, IN_PROGRESS, CLOSED
    }
}