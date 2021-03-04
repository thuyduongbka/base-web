package com.duong.demo._web.exception;

public class TestException extends RuntimeException{
    private String message;
    public TestException(String param){
        this.message = String.format("Exception in param [%s] ", param);
    }

    @Override
    public String getMessage() {
        return message;
    }
}
