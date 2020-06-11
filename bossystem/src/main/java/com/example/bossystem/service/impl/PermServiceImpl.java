package com.example.bossystem.service.impl;

import com.example.bossystem.mapper.PermMapper;
import com.example.bossystem.pojo.Authority;
import com.example.bossystem.service.PermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PermServiceImpl implements PermService {

    @Autowired
    private PermMapper permMapper;

    @Override
    public Authority getAuthByUid(Integer uid) {
        Authority authority = permMapper.getAuthByUid(uid);
        if(authority != null){
            return authority;
        }else{
            return null;
        }

    }

    @Override
    public int giveAuth(int uid) {

        return permMapper.giveAuth(uid);

    }
}
