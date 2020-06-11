package com.example.bossystem.mapper;


import com.example.bossystem.pojo.Authority;
import com.example.bossystem.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PermMapper {

    //根据登录用户的uid查询对应的权限
    public Authority getAuthByUid(Integer uid);

    //新增用户时，根据其uid给予相应的权限，
    public int  giveAuth(int uid);
}
