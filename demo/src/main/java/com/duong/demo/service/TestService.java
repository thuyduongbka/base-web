package com.duong.demo.service;

import com.duong.demo.base.BaseService;
import com.duong.demo.entity.TestEntity;
import com.duong.demo.exception.TestException;
import com.duong.demo.repository.TestRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService extends BaseService<TestEntity, TestRepository> {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestService.class);

    public String throwException(){
        throw new TestException("Test Service");
    }

    public List<TestEntity> findAll(){
        return repository.findAll();
    }
}
