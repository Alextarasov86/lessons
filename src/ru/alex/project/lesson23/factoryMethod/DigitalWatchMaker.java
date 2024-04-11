package ru.alex.project.lesson23.factoryMethod;

public class DigitalWatchMaker implements WatchMaker{
    @Override
    public Watch createWatch() {
        return new DigitalWatch();
    }
}
