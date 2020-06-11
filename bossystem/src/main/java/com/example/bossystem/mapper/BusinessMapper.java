package com.example.bossystem.mapper;

import com.example.bossystem.pojo.HandleInfo;
import com.example.bossystem.pojo.User;
import com.example.bossystem.pojo.UserOrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BusinessMapper {

    //获取所有客户信息
    public List<User> getAllClients();

    //根据客户id查询对应客户的订单
    public List<UserOrderInfo> getClientOrderByUid(Integer uid);

    //新增订单处理单信息
    public int addHandleInfo(HandleInfo info);

    //设置订单状态
    public int updateOrderInfo(@Param("order_no") Integer order_no, @Param("status") Integer status);

    //获取所有的调拨单信息
    public List<HandleInfo> getAllHandleInfos();
}
