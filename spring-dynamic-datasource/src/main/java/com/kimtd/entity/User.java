package com.kimtd.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "xx_user")
@Data
@NoArgsConstructor
public class User implements Serializable{
    @Id
    @GeneratedValue
    private Long userId;
    private String userName;
    private String email;
    private String address;
    private Date birthDay;
    private String password;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }


}
