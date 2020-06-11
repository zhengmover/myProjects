package com.example.bossystem.service.impl;

import com.example.bossystem.mapper.UserMapper;
import com.example.bossystem.pojo.User;
import com.example.bossystem.pojo.UserBuyInfo;
import com.example.bossystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

//    @Override
//    public int insertUserBuy(List<UserBuyInfo> goodsInfos) {
//        return 0;
//    }

}
