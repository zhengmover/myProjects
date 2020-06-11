package com.example.bossystem.service;

import com.example.bossystem.pojo.Authority;
import org.springframework.stereotype.Repository;


public interface PermService {
    //根据登录用户的uid查询对应的权限
    public Authority getAuthByUid(Integer uid);

    //新增用户时，根据其uid给予相应的权限，
    public int  giveAuth(int uid);
}
