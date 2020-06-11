package com.example.bossystem.service;

import com.example.bossystem.pojo.HandleInfo;
import com.example.bossystem.pojo.User;
import com.example.bossystem.pojo.UserOrderInfo;

import java.util.List;

public interface BusinessService {


    //获取所有客户信息
    public List<User> getAllClients();

    //根据客户id查询对应客户的订单
    public List<UserOrderInfo> getClientOrderByUid(Integer uid);

    //新增订单处理单信息
    public int addHandleInfo(HandleInfo info);

    //获取所有的调拨单信息
    public List<HandleInfo> getAllHandleInfos();
}
