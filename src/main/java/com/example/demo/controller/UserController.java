package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.util.IdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description
 * @Author lph
 * @Date 2019/5/23 17:58
 */
@RestController
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/findAll")
    public List<User> findAll(){
        List<User> list = userService.findAll();
        return list;
    }

    @PostMapping("/insertUser")
    public String insertUser(String name){
        User u = new User();
        u.setId(IdGenerator.getIdByUUId());
        u.setName(name);
        u.setPwd("123456");
        u.setEmail("it_lph@126.com");
        User user = userService.insert(u);
        return user.toString();
    }
}
