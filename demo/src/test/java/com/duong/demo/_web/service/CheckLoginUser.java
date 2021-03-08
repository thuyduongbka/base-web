package com.duong.demo._web.service;

import com.duong.demo._web.entity.UserEntity;
import com.duong.demo._web.exception.PasswordIncorrectException;
import com.duong.demo._web.exception.UserNotExistException;
import com.duong.demo._web.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

@SpringBootTest
public class CheckLoginUser {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @BeforeEach
    public void init(){
        UserEntity user = new UserEntity(1L,"duong@rabiloo", "123456");
        Mockito.when(userRepository.findByEmail("duong@rabiloo")).thenReturn(Optional.of(user));
    }

    @Test
    public void checkLoginUser_returnSuccess(){
        assertTrue(userService.login("duong@rabiloo", "123456").getId().equals(1L));
    }

    @Test
    public void checkLoginUser_returnUserNotExist(){
        assertThrows(UserNotExistException.class, () -> {
            userService.login("duong@rabiloo1", "123456");
        });
    }

    @Test
    public void checkLoginUser_returnPasswordIncorrect(){
        assertThrows(PasswordIncorrectException.class, () -> {
            userService.login("duong@rabiloo", "1234567");
        });
    }
}
