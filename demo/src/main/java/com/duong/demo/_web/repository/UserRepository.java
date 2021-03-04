package com.duong.demo._web.repository;

import com.duong.demo._web.base.BaseRepository;
import com.duong.demo._web.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long>{
    Optional<UserEntity> findByEmail(String email);
}
