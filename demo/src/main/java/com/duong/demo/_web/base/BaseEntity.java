package com.duong.demo._web.base;

import com.duong.demo._web.utils.CommonUtils;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
@Data
public abstract class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @GeneratedValue(generator = "uuid", strategy = GenerationType.AUTO)
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    protected UUID code;

    protected Date createdTime;

    protected Date updatedTime;

    protected Long createdByUserId;

    protected Long updatedByUserId;

    protected boolean isDeleted;

    @PrePersist
    protected void onCreate() {
        this.createdTime = new Date();
        this.updatedTime = createdTime;
        this.code = UUID.randomUUID();
        Long userId = CommonUtils.getCurrentUserId();
        createdByUserId = userId;
        updatedByUserId = userId;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedTime = new Date();
        Long userId = CommonUtils.getCurrentUserId();
        updatedByUserId = userId;
    }
}
