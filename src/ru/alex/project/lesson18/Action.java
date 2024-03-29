package ru.alex.project.lesson18;

import homework.lesson13.Animal;

public interface Action {
    void execute(Animal animal);

    default Action nextAction(Action next){
        return animal -> {
            execute(animal);
            if(next != null) next.execute(animal);
        };
    }
}
