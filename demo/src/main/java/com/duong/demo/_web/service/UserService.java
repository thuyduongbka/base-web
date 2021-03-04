package com.duong.demo._web.service;

import com.duong.demo._web.entity.UserEntity;
import com.duong.demo._web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.duong.demo._web.base.BaseService;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public String checkUserByEmail(String email) {
        Optional<UserEntity> userEntity = repository.findByEmail(email);
        if (userEntity.isPresent()) {
            // Send an email verify ...
            // Show a success message to end user ...
            return "SUCCESS";
        }
        // Send an error message to end user ...
        return "FAILED";
    }
}
