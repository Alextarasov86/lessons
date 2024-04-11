package ru.alex.project.lesson23.commandPattern;

// Concrete command
public class StartCommand implements Command{
    Computer computer;

    StartCommand(Computer computer){
        this.computer = computer;
    }

    @Override
    public void execute() {
        computer.start();
    }
}
