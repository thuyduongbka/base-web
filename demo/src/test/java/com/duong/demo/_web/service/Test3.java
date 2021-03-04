package com.duong.demo._web.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class Test3 {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void checkServerResponseContain() throws Exception {
        mockMvc.perform(get("/api/test/test-2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("success")));
    }
    @Test
    public void checkServerResponseContain2() throws Exception {
        mockMvc.perform(get("/api/test/test-2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("success")));
    }

}
