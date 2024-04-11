package ru.alex.project.lesson23;

public class GithubAuth implements Auth {


    @Override
    public boolean auth(String login, String password) {
        return false;
    }
}