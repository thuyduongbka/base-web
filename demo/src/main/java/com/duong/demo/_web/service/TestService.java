package com.duong.demo._web.service;

import com.duong.demo._web.base.BaseService;
import com.duong.demo._web.entity.TestEntity;
import com.duong.demo._web.exception.TestException;
import com.duong.demo._web.repository.TestRepository;
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
