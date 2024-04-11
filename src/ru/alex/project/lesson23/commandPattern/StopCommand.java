package ru.alex.project.lesson23.commandPattern;

public class StopCommand implements Command{
    Computer computer;

    StopCommand(Computer computer){
        this.computer = computer;
    }

    @Override
    public void execute() {
        computer.stop();
    }
}
