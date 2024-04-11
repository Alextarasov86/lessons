package ru.alex.project.lesson23;

public class AppAuth implements Auth {
    private String password;
    private String login;

    @Override
    public boolean auth(String login, String password) {
        return false;
    }
}