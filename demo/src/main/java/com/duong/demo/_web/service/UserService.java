package com.duong.demo._web.service;

import com.duong.demo._web.entity.UserEntity;
import com.duong.demo._web.exception.PasswordIncorrectException;
import com.duong.demo._web.exception.UserNotExistException;
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
    public UserEntity login(String email, String password){
        Optional<UserEntity> userEntityOptional = repository.findByEmail(email);
        if (userEntityOptional.isPresent()) {
            UserEntity user = userEntityOptional.get();
            if (user.getPassword().equals(password)){
                return user;
            }
            throw new PasswordIncorrectException();
        } else {
            throw new UserNotExistException(email);
        }
    }
}
