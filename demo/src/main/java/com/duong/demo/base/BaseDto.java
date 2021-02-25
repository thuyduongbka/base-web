package com.duong.demo.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class BaseDto {
    protected Long id;

    protected UUID code;

    protected Date createdTime;

    protected Date updatedTime;

    @JsonIgnore
    protected Long createdByUserId;

    @JsonIgnore
    protected Long updatedByUserId;

    protected boolean isDeleted;
}
