package com.example.bossystem.controller;

import com.example.bossystem.pojo.GoodsInfo;
import com.example.bossystem.pojo.User;
import com.example.bossystem.pojo.UserBuyInfo;
import com.example.bossystem.pojo.UserOrderInfo;
import com.example.bossystem.service.GoodsService;
import com.example.bossystem.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class UserControler {

    @Autowired
    UserService userService;
    @Autowired
    GoodsService goodsService;
    @Autowired
    UserOrderInfo userOrderInfo;


    @RequestMapping(value = "/user/update")
    @ResponseBody
    public String updateUser(User user, HttpSession session){
        //获取登录成功后存放在session域中的id，封装成一个完整的user
        int id = Integer.parseInt(session.getAttribute("uid").toString());
        user.setUid(id);
        //执行更新语句
        int flag = userService.updateUser(user);

        if(flag == 1){
            //如果更新成功，返回接送数据为"success"字符串
            return "success";
        }else{
            //如果更新失败，返回接送数据为"failure"字符串
            return "failure";
        }



    }


    @RequestMapping("/user/allGoodsInfo")
    public String getAllGoodsInfo(Model model){
        List<GoodsInfo> goodsInfos = goodsService.getAllGoodsInfo();
        //向页面返回查出的所有类别水果
        model.addAttribute("goodsInfos",goodsInfos);
        return "user/showGoods";
    }

    @RequestMapping("/user/userOrder")
    public String userOrder(){
        return "user/userOrder";
    }


    @PostMapping("/user/buyGoods")
    @ResponseBody
    public String userBuyGoods(@RequestParam Map<String, Object> params,
                               HttpSession session) throws ParseException { //参数params为页面标签为input的值

        if (Integer.parseInt(params.get("gtotal").toString()) == 0){//如果商品总价为空，即没有购买
            return "failure";
        }
        Map<Integer,Integer> ids = new HashMap<>();//用来存放不同水果与购买对应的数量
        double total = 0;//用来存储总价
        Integer uid =  Integer.parseInt(session.getAttribute("uid").toString());//获取用户id
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置时间格式
        List<Integer> goodIds = new LinkedList<>();//存放选择购买的水果id集合
        List<UserBuyInfo> goods = new LinkedList<>();

        for (String param : params.keySet()){//循环将页面传回的key-value放进一个map
            if(param.contains("text")){//页面参数为购买箱数
                String str = param.replace("text_","");
                ids.put(Integer.parseInt(str),Integer.parseInt((String) params.get(param)));
                if (Integer.parseInt((String) params.get(param)) > 0){//如果此类水果被购买了
                    goodIds.add(Integer.parseInt(str));
                }

            }else{
                total = Double.parseDouble(params.get(param).toString());//获取页面传来的总价
            }
        }

        //生成用户订单对象
        userOrderInfo.setUser_id(uid);
        userOrderInfo.setGtotal(total);
        userOrderInfo.setOrder_time(df.parse(df.format(new Date())));
        userOrderInfo.setStatus(0);
        int flag1 = goodsService.updateGoods(ids);//更新货物数据库传回的标志
        int flag2 = goodsService.insertToUserOrder(userOrderInfo);//将用户订单插入用户订单表
        List<GoodsInfo> goodsInfos = goodsService.getGoodByIds(goodIds);//获取用户所购买的水果信息
        int user_no = goodsService.getMaxOrderId();//获取此次的订单号

        for (GoodsInfo goodsInfo : goodsInfos){//封装用户购买的水果信息到集合中
           UserBuyInfo userBuyInfo = new UserBuyInfo();
           userBuyInfo.setUser_id(uid);
           userBuyInfo.setGname(goodsInfo.getGname());
           userBuyInfo.setGcount(Integer.parseInt(params.get("text_"+goodsInfo.getId()).toString()));
           userBuyInfo.setOrder_no(user_no);
           userBuyInfo.setGpath(goodsInfo.getGpath());
           goods.add(userBuyInfo);
        }

        int flag3 = goodsService.insertToUserBuy(goods);

        if((flag1>0)&&(flag2>0)&&(flag3>0)){//如果上述操作都成功，则返回success，否咋返回failure
            return "success";
        }else{
            return "failure";
        }

    }


    //完成用户订单展示
    @RequestMapping("/user/showUserOrder")
    public String showUserOrder(Model model,HttpSession session){
        Integer uid =  Integer.parseInt(session.getAttribute("uid").toString());//获取用户id
        //获取根据用户id用户所有的订单信息
        List<UserOrderInfo> userOrderInfoList = goodsService.getAllUserOrderInfoByUid(uid);

        //存储用户的所有订单的商品信息,订单id与用户一次订单所购买的商品信息对应
        Map<Integer,List<UserBuyInfo>> allUserBuyInfo = new HashMap<>();

        for (UserOrderInfo userOrderInfo : userOrderInfoList){
            //获得用户一次订单所购买的商品信息
            List<UserBuyInfo> userBuyInfoList = goodsService.getAllUserBuyByUidAndOrderno(uid,userOrderInfo.getOrder_no());
            //用户的所有订单的商品信息,订单id与用户一次订单所购买的商品信息对应
            allUserBuyInfo.put(userOrderInfo.getOrder_no(),userBuyInfoList);
        }
        model.addAttribute("userOrderInfoList",userOrderInfoList);
        model.addAttribute("allUserBuyInfo",allUserBuyInfo);
        return "user/userOrder";
    }

    //用户确认订单收到
    @RequestMapping("/user/setUserInfoRecv/{order_no}")
    @ResponseBody
    public String setUserInfoRecv(@PathVariable("order_no")Integer order_no){
        int flag = goodsService.setUserInfoRecv(order_no);
        if (flag > 0){
            return "success";
        }else{
            return "failure";
        }
    }
}
