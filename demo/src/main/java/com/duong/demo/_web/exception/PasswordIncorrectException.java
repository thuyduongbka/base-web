package com.duong.demo._web.exception;

public class PasswordIncorrectException extends RuntimeException {
    private String message;
    public PasswordIncorrectException(){
        this.message = String.format("Password incorrect!");
    }

    @Override
    public String getMessage() {
        return message;
    }
}
