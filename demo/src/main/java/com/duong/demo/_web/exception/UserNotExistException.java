package com.duong.demo._web.exception;

public class UserNotExistException extends RuntimeException{
    private String message;
    public UserNotExistException(String param){
        this.message = String.format("Email [%s] not found", param);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
