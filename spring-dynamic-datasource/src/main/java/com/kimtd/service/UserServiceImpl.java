package com.kimtd.service;


import com.kimtd.entity.User;
import com.kimtd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

//    @CacheEvict(value = "serviceCache",allEntries = true)
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void edit(User user) {
        userRepository.saveAndFlush(user);
    }

    //    @CacheEvict(value = "serviceCache",allEntries = true,beforeInvocation = true)
    public void remove(Long id) {
        userRepository.delete(id);
    }

//    @Cacheable(value = "serviceCache")
    public User getUser(Long id) {
       return userRepository.findOne(id);
    }

//    @Cacheable(value = "serviceCache")
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
