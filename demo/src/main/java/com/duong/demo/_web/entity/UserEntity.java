package com.duong.demo._web.entity;

import lombok.Data;
import com.duong.demo._web.base.BaseEntity;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    private String email;
    private String password;

    public UserEntity(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserEntity() {
    }
}
