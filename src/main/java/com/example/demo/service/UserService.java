package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

/**
 * @Description
 * @Author lph
 * @Date 2019/5/23 17:54
 */
public interface UserService {
    List<User> findAll();
    User insert(User user);
}
