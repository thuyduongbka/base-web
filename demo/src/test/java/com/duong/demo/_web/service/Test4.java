package com.duong.demo._web.service;

import com.duong.demo._web.rest.api.TestApi;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TestApi.class)
public class Test4 {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TestService service;


    @Test
    public void testApiFindAll() throws Exception {
        when(service.findAll()).thenReturn(new ArrayList<>());
        this.mockMvc.perform(get("/api/test/test-find-all"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
