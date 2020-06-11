package com.example.bossystem.service;

import com.example.bossystem.pojo.User;
import org.springframework.stereotype.Repository;


public interface LoginService {

    //根据用户名查询用户对象
    public User getUserByName(String uname);

    //注册用户时插入
    public boolean insertUser(User user);


}
