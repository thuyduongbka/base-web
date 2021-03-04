package com.duong.demo._test.arrival;

import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "arrival")
public class Arrival {

    @Id
    @Column
    @GeneratedValue
    private int id;

    @Column
    private String city;

}
