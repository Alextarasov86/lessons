package ru.alex.project.lesson19;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class NullSafeContainer<T> {
    private T value;

    NullSafeContainer(T value){
        this.value = value;
    }

    public T getValueOr(Supplier<T> supplier){
        if(value != null) return value;
        return supplier.get();
    }

    public void ifExist(Consumer<T> consumer, Runnable runnable){
        if(value != null){
            consumer.accept(value);
        } else {
            runnable.run();
        }
    }
}
