package homework.lesson21;

import ru.alex.project.lesson18.Action;

import java.util.function.Predicate;

@FunctionalInterface
public interface TaskPredicate extends Predicate<Task> {

}
