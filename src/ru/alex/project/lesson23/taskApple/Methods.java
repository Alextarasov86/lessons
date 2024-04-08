package ru.alex.project.lesson23.taskApple;

import java.io.IOException;
import java.util.List;

public interface Methods<T, ID> {

    List<Apple> getApples() throws IOException;
    Apple getAppleToId(ID id) throws IOException;
    void addApple(Apple apple) throws IOException;
    void removeApple(Apple apple) throws IOException;
}
