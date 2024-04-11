package ru.alex.project.lesson23.commandPattern;

public class ResetCommand implements Command{
    Computer computer;

    ResetCommand(Computer computer){
        this.computer = computer;
    }

    @Override
    public void execute() {
        computer.reset();
    }
}
