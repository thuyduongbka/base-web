package com.duong.demo._web.entity;

import com.duong.demo._web.base.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "test")
@Data
public class TestEntity extends BaseEntity {
    private String name;
}
