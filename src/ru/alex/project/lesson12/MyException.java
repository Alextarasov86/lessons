package ru.alex.project.lesson12;

import java.time.LocalDateTime;

public class MyException extends Exception{

    MyException(String message){
        super(message);
    }

    MyException(String message, Throwable throwable){
        super(message, throwable);
    }

    @Override
    public String getMessage(){
        return super.getMessage() + LocalDateTime.now();
    }

}
