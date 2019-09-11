package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author lph
 * @Date 2019/5/23 17:56
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RedisUtil redisUtil;
    @Override
    public List<User> findAll() {
        List<User> list = userDao.findAll();
        redisUtil.lSet("userList",list);
        return list;
    }

    @Override
    public User insert(User user) {
        redisUtil.set("insertUser",user);
        User u = userDao.save(user);
        return u;
    }
}
