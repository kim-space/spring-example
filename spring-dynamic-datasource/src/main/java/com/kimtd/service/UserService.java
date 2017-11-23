package com.kimtd.service;


import com.kimtd.entity.User;

import java.util.List;


public interface UserService {

    void save(User user);

    void edit(User user);

    void remove(Long id);

    User getUser(Long id);

    List<User> findAll();
}
