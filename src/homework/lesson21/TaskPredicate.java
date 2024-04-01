package homework.lesson21;

import ru.alex.project.lesson18.Action;

@FunctionalInterface
public interface TaskPredicate {
    boolean check(Task task);

    default TaskPredicate and(TaskPredicate next){
        return task -> {
            check(task);
            if(next != null) next.check(task);

            return false;
        };
    }
}
