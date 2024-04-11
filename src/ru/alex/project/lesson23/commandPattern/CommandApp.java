package ru.alex.project.lesson23.commandPattern;

import java.util.HashMap;
import java.util.Map;

public class CommandApp {
    public static void main(String[] args) {
        Computer computer = new Computer();
        User user = new User(new StartCommand(computer), new StopCommand(computer), new ResetCommand(computer));
        user.startComputer();
        user.stopComputer();
        user.resetComputer();


    }
}
