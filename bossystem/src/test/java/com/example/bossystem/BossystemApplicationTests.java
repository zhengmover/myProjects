package com.example.bossystem;

import com.example.bossystem.mapper.*;
import com.example.bossystem.pojo.*;
import com.example.bossystem.service.LoginService;
import com.example.bossystem.service.PermService;
import com.example.bossystem.service.UserService;
import com.example.bossystem.service.impl.PermServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootTest
class BossystemApplicationTests {

    @Autowired
    GoodsMapper goodsMapper;
    @Test
    void contextLoads() throws ParseException {


        System.out.println(goodsMapper.getAllPurchaseInfo());
    }

}
