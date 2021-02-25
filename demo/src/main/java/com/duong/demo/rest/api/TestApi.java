package com.duong.demo.rest.api;

import com.duong.demo.rest.response.ResponseErrorType;
import com.duong.demo.rest.response.ServerResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/test")
public class TestApi {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestApi.class);

    @GetMapping("/test-1")
    public ResponseEntity test1(){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Actor Not Found", new Exception());
    }

    @GetMapping("/test-2")
    public ServerResponseDto test2(){
        return ServerResponseDto.fail(ResponseErrorType.SERVER_ERROR);
    }
}
