package ru.alex.project.lesson23.commandPattern;

// Invoker
public class User {
    Command start;
    Command stop;
    Command reset;

    User(Command start, Command stop, Command reset){
        this.start = start;
        this.stop = stop;
        this.reset = reset;
    }

    void startComputer(){
        start.execute();
    }
    void stopComputer(){
        stop.execute();
    }
    void resetComputer(){
        reset.execute();
    }
}
