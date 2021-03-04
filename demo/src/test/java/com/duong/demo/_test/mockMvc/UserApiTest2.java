package com.duong.demo._test.mockMvc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserApiTest2 {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void checkEmailExist_ReturnSuccess() throws Exception {
        mockMvc.perform(get("/api/user/check-exist?email='a@1'"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("SUCCESS"));
    }
    @Test
    public void checkEmailExist2_ReturnSuccess() throws Exception {
        mockMvc.perform(get("/api/user/check-exist").param("email", "a@1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("SUCCESS"));
    }
}
