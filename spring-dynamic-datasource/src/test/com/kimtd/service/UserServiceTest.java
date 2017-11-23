package com.kimtd.service;

import com.kimtd.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void init(){
        System.out.println("init success");
    }

    @Test
    public void save() throws Exception {
        User kim = new User("slave", "123456");
        userService.save(kim);
    }

    @Test
    public void edit() throws Exception {
    }

    @Test
    public void remove() throws Exception {
    }

    @Test
    public void getUser() throws Exception {
    }

    @Test
    public void findAll() throws Exception {
    }

}