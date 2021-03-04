package com.duong.demo._web.rest.api;

import com.duong.demo._web.exception.TestException;
import com.duong.demo._web.rest.response.ResponseErrorType;
import com.duong.demo._web.rest.response.ServerResponseDto;
import com.duong.demo._web.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/test")
public class TestApi {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestApi.class);

    @Autowired
    private TestService testService;

    @GetMapping("/test-1")
    public ResponseEntity test1(){
        LOGGER.info("Logger infor {}", "test");
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Actor Not Found", new Exception());
    }

    @GetMapping("/test-2")
    public ServerResponseDto test2(){
        return ServerResponseDto.success("body success");
    }

    @GetMapping("/test-3")
    public ServerResponseDto test3(){
        try {
            return ServerResponseDto.success(testService.throwException());
        } catch (TestException e){
            return ServerResponseDto.fail(ResponseErrorType.SERVER_ERROR);
        }
    }

    @GetMapping("/test-find-all")
    public ServerResponseDto findAll(){
        try {
            return ServerResponseDto.success(testService.findAll());
        } catch (TestException e){
            return ServerResponseDto.fail(ResponseErrorType.SERVER_ERROR);
        }
    }

}
