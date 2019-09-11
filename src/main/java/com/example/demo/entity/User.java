package com.example.demo.entity;


import javax.persistence.*;
import java.io.Serializable;

/**
 * @Description
 * @Author lph
 * @Date 2019/5/23 17:00
 */
@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY) // 主键自增
    private String id;
    private String name;
    private String pwd;
    /**
     * 忽略该字段的映射
     * 如果不忽略，保存数据时表中会新创建一列
     */
    //@Transient
    private String email;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
