package com.kimtd.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_emp")
@Data
@ToString
public class Employee {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer age;
    private String name;

}
