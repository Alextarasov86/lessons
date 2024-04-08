package ru.alex.project.lesson23.taskApple;

import java.util.List;

public class AppleStorage implements Methods<Apple, Long> {
    List<Apple> apples;


    @Override
    public List<Apple> getApples() {
        return apples;
    }

    @Override
    public Apple getAppleToId(Long id) {
        Apple apple1 = null;
        for (Apple apple : apples) {
            if (apple.id() == id) {
                apple1 = apple;
            }
        }
        return apple1;
    }

    @Override
    public void addApple(Apple apple) {
        apples.add(apple);
    }

    @Override
    public void removeApple(Apple apple) {
        for (Apple apple1 : apples) {
            if(apple1.equals(apple)){
                apples.remove(apple1);
            }
        }
    }
}
