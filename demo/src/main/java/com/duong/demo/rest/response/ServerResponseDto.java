package com.duong.demo.rest.response;

import lombok.Data;

@Data
public class ServerResponseDto<T> {
    private boolean success = true;
    private T body = null;
    private ResponseErrorType errorType;

    public ServerResponseDto() {
        super();
    }

    /**
     * method return ServerResponseDto with status = false and errorType = errorType parameter.
     */
    public static ServerResponseDto<Void> fail(ResponseErrorType errorType) {
        ServerResponseDto<Void> responseDto = new ServerResponseDto<>();
        responseDto.setSuccess(false);
        responseDto.setErrorType(errorType);
        return responseDto;
    }

    public static <T> ServerResponseDto<T> fail(T body, ResponseErrorType errorType) {
        ServerResponseDto<T> responseDto = new ServerResponseDto<>();
        responseDto.setSuccess(false);
        responseDto.setErrorType(errorType);
        responseDto.setBody(body);
        return responseDto;
    }

    /**
     * method return ServerResponseDto with status = true and body = body parameter.
     *
     * @param body : server response body
     */
    public static <T> ServerResponseDto<T> success(T body) {
        ServerResponseDto<T> responseDto = new ServerResponseDto<>();
        responseDto.setSuccess(true);
        responseDto.setBody(body);
        return responseDto;
    }
}
