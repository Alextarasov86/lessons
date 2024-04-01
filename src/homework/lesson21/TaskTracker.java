package homework.lesson21;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TaskTracker {
    private String name;
    private Set<TaskToParticipant> tasks;

    // taskPredicates - условия добавления задач. Тип данных определить самостоятельно
    // условие добавление задачи по умолчанию: задача должна быть открытой
    // может быть заменено методом taskSettings
    private /* Тип данных */ Predicate<Task> taskPredicates = task -> task.getStatus() != Task.Status.CLOSED;

    // participantPredicates - условия добавления исполнителей. Тип данных определить самостоятельно
    // условие добавление исполнителя по умолчанию: исполнитель должен быть
    // доступен по свойству active
    // может быть заменено методом participantSettings
    private /* Тип данных */ Predicate<Participant> participantPredicates = Participant::isActive;

    // конструктор не должен быть доступен вне класса
    // создание TaskTracker происходит вызовом статического метода withTitle,
    // метод принимает на вход название создает и возвращает экземпляр TaskTracker
    private TaskTracker(){}

    public static TaskTracker withTitle(String title){
        TaskTracker taskTracker = new TaskTracker();
        taskTracker.name = title;
        return taskTracker;
    }


    // TaskPredicate - функциональный интерфейс -
    // его абстрактный метод принимает задачу, возвращает ture или false
    public TaskTracker taskSettings(TaskPredicate... predicates) {
        // predicates - массив типа TaskPredicate -
        // условия добавления задач,
        // например, predicates - задача должна быть срочной
        //                      - задача должна быть новой
        //                      - задача должна быть просроченной
        // все условия хранятся в TaskPredicate
        for (TaskPredicate predicate : predicates) {
            tasks = tasks.stream().filter(taskToParticipant -> predicate.check(taskToParticipant.getTask())).
                    collect(Collectors.toCollection(HashSet::new));
        }
        return this;
    }


    // ParticipantPredicate - функциональный интерфейс -
    // его абстрактный метод принимает задачу, возвращает ture или false
    public TaskTracker participantSettings(ParticipantPredicate... predicates) {
        // predicates - массив типа ParticipantPredicate -
        // условия добавления исполнителей
        // например, predicates - опыт работы выше 5
        //                      - исполнитель должен быть доступен
        //                      - у исполнителя еще нет задач
        // все условия хранятся в participantPredicates
        for (ParticipantPredicate predicate : predicates) {
            tasks = tasks.stream().filter(taskToParticipant -> predicate.check(taskToParticipant.getParticipant())).
                    collect(Collectors.toCollection(HashSet::new));
        }
        return this;
    }

    public TaskTracker add(Task task, Participant participant) {
        // создается TaskToParticipant, если задача (task) и исполнитель (participant)
        // удовлетворяют требованиям taskPredicates и participantPredicates
        // TaskToParticipant добавляется в tasks
        TaskToParticipant taskToParticipant = new TaskToParticipant();
        if(taskPredicates.test(task) && participantPredicates.test(participant)){
            taskToParticipant.setTask(task);
            taskToParticipant.setParticipant(participant);
            tasks.add(taskToParticipant);
        }
        return this;
    }

    // возвращает статистику по текущему состоянию трекера
    public TasksTrackerStatistic getStatistics() {
        // реализовать метод, используя collectors api
        // посмотрите методы teeing() и reducing()
        TasksTrackerStatistic trackerStatistic =new TasksTrackerStatistic();
        List<Task> closedTask = tasks.stream().map(
                taskToParticipant -> taskToParticipant.getTask()).filter(task -> task.getStatus() == Task.Status.CLOSED).toList();
        trackerStatistic.setNumberOfClosed(closedTask.size());
        Set<Participant> participants = tasks.stream().map(TaskToParticipant::getParticipant).
                collect(Collectors.toCollection(HashSet::new));
        trackerStatistic.setNumberOfParticipants(participants.size());
        List<Task> overdueTask = tasks.stream().map(TaskToParticipant::getTask).
                filter(task -> task.getCloseTo().isAfter(LocalDateTime.now()) && task.getStatus() != Task.Status.CLOSED).toList();
        trackerStatistic.setNumberOfFailed(overdueTask.size());
        List<Task> inProgressTask = tasks.stream().map(TaskToParticipant::getTask).
                filter(task -> task.getStatus() == Task.Status.IN_PROGRESS).toList();
        trackerStatistic.setNumberOfInProgress(inProgressTask.size());
        return null;
    }

    // возвращает Map,
    // где ключи - идентификаторы исполнителей
    // значения - все его открытые задачи
    public Map<Integer, List<Task>> groupTasksByParticipantId() {
        Map<Integer, List<Task>> map1 = tasks.stream()
                .collect(Collectors.groupingBy(
                        taskToParticipant -> taskToParticipant.getParticipant().getId(),
                        Collectors.mapping(TaskToParticipant::getTask,
                                Collectors.filtering(task -> task.getStatus() != Task.Status.CLOSED, Collectors.toList()))
                ));
        return map1;
    }

    // возвращает Map,
    // где ключи - статус задачи
    // значения - Map,
    //      где ключи - статусы задач,
    //      значения - списки идентификаторов задач
    public Map<Task.Status, Map<Task.Priority, List<Integer>>>
    groupTasksIdByStatusAndPriority() {
        Map<Task.Status, Map<Task.Priority, List<Integer>>> map2 = tasks.stream().collect(Collectors.groupingBy(
                taskToParticipant -> taskToParticipant.getTask().getStatus(),
                Collectors.groupingBy(taskToParticipant -> taskToParticipant.getTask().getPriority(),
                        Collectors.mapping(taskToParticipant -> taskToParticipant.getTask().getId(), Collectors.toList()))
        ));
        return map2;
    }

    // возвращает неизменяемый список задач, прошедших проверку predicate
    public List<Task> filteredTasks(TaskPredicate predicate) {
        List<Task> list = tasks.stream().map(TaskToParticipant::getTask).filter(predicate::check).toList();
        return null;
    }
}