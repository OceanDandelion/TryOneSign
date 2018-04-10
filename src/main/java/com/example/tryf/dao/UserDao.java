package com.example.tryf.dao;

import com.example.tryf.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User,Integer> {


    User findByUsername(String username);
}
