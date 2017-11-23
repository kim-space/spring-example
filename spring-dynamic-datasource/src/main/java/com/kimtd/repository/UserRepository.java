package com.kimtd.repository;

import com.kimtd.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Long>{

    User findByUserName(String name);
}
