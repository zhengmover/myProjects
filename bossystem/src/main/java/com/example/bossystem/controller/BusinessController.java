package com.example.bossystem.controller;


import com.example.bossystem.pojo.*;
import com.example.bossystem.service.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller//负责对客户订单进行处理
public class BusinessController {

    @Autowired
    BusinessService businessService;
    @Autowired
    UserService userService;
    @Autowired
    GoodsService goodsService;
    @Autowired
    TransportService transportService;
    @Autowired
    SystemService systemService;

    //显示所有客户信息
    @RequestMapping("/admin/clientsManage")
    public String showClients(Model model){
        List<User> users = businessService.getAllClients();

        model.addAttribute("users",users);
        return "admin/showCients";
    }

    //获取对应的客户订单
    @RequestMapping("/admin/clientOrder/{uid}")
    public String showClientOrder(@PathVariable("uid") Integer uid,Model model){
        List<UserOrderInfo> clientOrderInfos = businessService.getClientOrderByUid(uid);
        User user = userService.getUserById(uid);
        model.addAttribute("infos",clientOrderInfos);
        model.addAttribute("user",user);
        return "admin/clientOrder";
    }

    //展示某一订单
    @RequestMapping("/admin/orderDetail")
    public String showOrderDetail(@Param("uid") Integer uid,
                              @Param("order_no") Integer order_no,Model model){
        //查出对应订单详情
        List<UserBuyInfo> infos = goodsService.getAllUserBuyByUidAndOrderno(uid, order_no);
        User user = userService.getUserById(uid);
        model.addAttribute("infos",infos);
        model.addAttribute("user",user);
        model.addAttribute("order_no",order_no);
        return "admin/orderDetail";
    }

    @RequestMapping("/admin/handleOrder")
    public String handleOrder(@Param("order_no") Integer order_no,Model model){
            //查询得到订单信息
            UserOrderInfo userOrderInfo = goodsService.getUserOrderInfoById(order_no);
            //查询该订单对应的客户信息
            User user = userService.getUserById(userOrderInfo.getUser_id());
            //查询可使用的，合适的车辆信息
            List<Car> cars = transportService.getUsableCars(order_no);

            model.addAttribute("info",userOrderInfo);
            model.addAttribute("user",user);
            model.addAttribute("cars",cars);

            return "admin/handleOrder";
    }

//调拨单处理
    @RequestMapping("/admin/handle")
    @ResponseBody
    public String handle(HandleInfo info){
        int flag = businessService.addHandleInfo(info);
        if(flag > 0){
            return "success";
        }else{
            return "failure";
        }
    }

    //展示调拨单信息
    @RequestMapping("/admin/showHandleInfo")
    public String showHandleInfo(Model model){
        List<HandleInfo> infos = businessService.getAllHandleInfos();
        model.addAttribute("infos",infos);
        return "admin/handleInfos";
    }


}
