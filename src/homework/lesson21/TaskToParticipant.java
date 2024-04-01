package homework.lesson21;

public class TaskToParticipant {
    private Participant participant;
    private Task task;
    private int progress;


    // геттеры и сеттеры


    public Participant getParticipant() {
        return participant;
    }

    public Task getTask() {
        return task;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}