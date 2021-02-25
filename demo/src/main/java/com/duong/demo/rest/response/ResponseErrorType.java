package com.duong.demo.rest.response;

public enum ResponseErrorType {

    SERVER_ERROR(500, "SERVER_ERROR"),
    NOT_FOUND(404, "NOT_FOUND");


    ResponseErrorType(int code, String messenger) {
        this.code = code;
        this.messenger = messenger;
    }

    private int code;
    private String messenger;
}
