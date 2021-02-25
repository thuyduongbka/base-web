package com.duong.demo.service;

import com.duong.demo.exception.TestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestService.class);

    public String throwException(){
        throw new TestException("Test Service");
    }
}
