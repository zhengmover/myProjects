package com.example.bossystem.service;

import com.example.bossystem.pojo.User;
import com.example.bossystem.pojo.UserBuyInfo;

import java.util.List;
import java.util.Map;

public interface UserService {

    //用户修改个人信息时调用
    public int updateUser(User user);

    //根据用户id取出对应用户
    public User getUserById(Integer id);

//    //购买商品时记录下
//    public int insertUserBuy(List<UserBuyInfo> goodsInfos);
}
