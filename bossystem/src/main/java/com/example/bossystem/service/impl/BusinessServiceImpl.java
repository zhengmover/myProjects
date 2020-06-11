package com.example.bossystem.service.impl;

import com.example.bossystem.mapper.BusinessMapper;
import com.example.bossystem.mapper.GoodsMapper;
import com.example.bossystem.mapper.SystemMapper;
import com.example.bossystem.mapper.TransportMapper;
import com.example.bossystem.pojo.*;
import com.example.bossystem.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    BusinessMapper businessMapper;
    @Autowired
    TransportMapper transportMapper;
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    SystemMapper systemMapper;
    //获取所有客户信息
    public List<User> getAllClients() {
        List<User> users = businessMapper.getAllClients();
        return users;
    }

    //根据客户id查询对应客户的订单
    public List<UserOrderInfo> getClientOrderByUid(Integer uid) {
        List<UserOrderInfo> clientOrderInfos = businessMapper.getClientOrderByUid(uid);

        return clientOrderInfos;
    }

    //新增订单处理单信息
    public int addHandleInfo(HandleInfo info) {
        int flag1 = businessMapper.addHandleInfo(info);//先执行新增订单处理单信息操作
        Car car = transportMapper.getCarById(info.getCar_id());//获取处理订单的车辆信息
        int count = goodsMapper.getGoodsCountByOrderNo(info.getOrder_id());
        car.setUsed_traffic(car.getUsed_traffic()+count);
        int flag2 = transportMapper.updateCar(car);//更新车辆信息
        int flag4 = businessMapper.updateOrderInfo(info.getOrder_id(),1);
        if((flag1 > 0)&&(flag2 > 0)&&(flag4 > 0)){//如果操作都成功
            return 1;
        }else{
            return 0;
        }


    }

    //获取所有的调拨单信息
    public List<HandleInfo> getAllHandleInfos() {

        List<HandleInfo> infos = businessMapper.getAllHandleInfos();
        return infos;
    }
}
