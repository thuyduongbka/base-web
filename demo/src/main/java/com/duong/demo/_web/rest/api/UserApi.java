package com.duong.demo._web.rest.api;

import com.duong.demo._web.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserApi {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestApi.class);

    @Autowired
    private UserService userService;

    @GetMapping("/check-exist")
    public String checkExist(@RequestParam String email){
       return userService.checkUserByEmail(email);
    }
}
