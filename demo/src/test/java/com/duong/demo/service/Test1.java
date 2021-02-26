package com.duong.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
public class Test1 {
    @Autowired
    private TestService testService;

    @Test
    public void contextLoads() throws Exception {
        assertThat(testService).isNotNull();
    }
}
