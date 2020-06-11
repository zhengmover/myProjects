package com.example.bossystem.mapper;


import com.example.bossystem.pojo.Authority;
import com.example.bossystem.pojo.User;
import com.example.bossystem.pojo.UserBuyInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

//这是一个操作用户表的mapper类，dao
@Mapper
@Repository
public interface UserMapper {
     //根据用户名取出对应用户
     public User getUserByName(String username);

     //注册用户时调用
     public int insertUser(User user);

     //用户修改个人信息时调用
     public int updateUser(User user);

     //根据用户id取出对应用户
     public User getUserById(Integer id);

//     //购买商品时记录下
//     public int insertUserBuy(List<UserBuyInfo> goodsInfos);


}
