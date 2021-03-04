package com.duong.demo._test.mockito;

import com.duong.demo._web.rest.api.UserApi;
import com.duong.demo._web.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.boot.test.mock.mockito.MockBean;
import static org.mockito.Mockito.when;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.assertEquals;


@WebMvcTest(UserApi.class)
public class UserApiTest {

    @MockBean
    public UserService service;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void findUser_WhenEmailExisted_ReturnFailed() {
        when(service.checkUserByEmail("a@123")).thenReturn("SUCCESS");
        assertEquals("SUCCESS", service.checkUserByEmail("a@123"));
    }

    @Test
    public void findUserEmailApi_WhenEmailExisted_ReturnFailed() throws Exception {
        when(service.checkUserByEmail("a@1")).thenReturn("SUCCESS");
        mockMvc.perform(get("/api/user/check-exist?email='a@1'"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("SUCCESS"));
    }
    @Test
    public void findUserEmailApi2_WhenEmailExisted_ReturnFailed() throws Exception {
        when(service.checkUserByEmail("a@1")).thenReturn("SUCCESS");
//        when(service.checkUserByEmail("a@1")).thenReturn("FAILED");
        mockMvc.perform(get("/api/user/check-exist").param("email", "a@1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("SUCCESS"));
    }



}
