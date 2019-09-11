package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Description
 * @Author lph
 * @Date 2019/5/23 17:33
 */
//将实体类型和实体类的id类型作为类型参数。
public interface UserDao extends JpaRepository<User,String> {
    User findByName(String name);
}
