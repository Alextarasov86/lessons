package ru.alex.project.lesson18;

import java.util.function.Predicate;

public interface Notification {

    boolean send(String message);

    default Notification add(Notification notification, Predicate<String> predicate){
        return message -> {
            send(message);
            if(predicate.test(message)) return notification.send(message);
            return true;
        };
    }
}
