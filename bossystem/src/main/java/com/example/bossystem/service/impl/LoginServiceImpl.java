package com.example.bossystem.service.impl;

import com.example.bossystem.mapper.PermMapper;
import com.example.bossystem.mapper.UserMapper;
import com.example.bossystem.pojo.User;
import com.example.bossystem.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;


@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PermMapper permMapper;



    @Override
    public User getUserByName(String uname) {
        User user = userMapper.getUserByName(uname);
        if(user != null){
            return user;
        }else {
            return null;
        }

    }

    @Override
    public boolean insertUser(User user) {
        /*先根据传入的username判断数据库中是否存在相同的username，
        若存在，则告诉用户注册的用户名已存在
        */
            boolean flag = false;

            User entity = userMapper.getUserByName(user.getUname());

            if(entity != null){//如果存在相同的用户名
                return false;
            }else{
                if(userMapper.insertUser(user) > 0){//如果插入成功
                    //插入成功后，给普通用户设置访问权限
                    int id =userMapper.getUserByName(user.getUname()).getUid();

                    //为刚创建的用户添加权限
                    permMapper.giveAuth(id);
                    flag = true;
                }
            }

        return flag;
    }
}
