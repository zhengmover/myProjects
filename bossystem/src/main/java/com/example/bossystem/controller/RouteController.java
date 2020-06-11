package com.example.bossystem.controller;


import com.example.bossystem.pojo.Car;
import com.example.bossystem.pojo.RouteInfo;
import com.example.bossystem.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class RouteController {

    @Autowired
    TransportService transportService;

    //展示所有发路线信息
    @RequestMapping("/admin/showRouteInfo")
    public String showRouteInfo(Model model){
        List<RouteInfo> infos = transportService.getAllRoutes();
        model.addAttribute("infos",infos);
        return "admin/showRoute";
    }

    //删除某条对应的路线信息
    @RequestMapping("/admin/delRoute/{rid}")
    @ResponseBody
    public String delCar(@PathVariable("rid") Integer rid){
        int flag = transportService.delRoute(rid);
        if(flag > 0){
            return "success";
        }else{
            return "failure";
        }
    }

    @RequestMapping("/admin/updateRoute")
    @ResponseBody
    public String updateRoute(RouteInfo routeInfo){
        int flag = transportService.updateRoute(routeInfo);
        if(flag > 0){
            return "success";
        }else{
            return "failure";
        }
    }

    @RequestMapping("/admin/addRoute")
    @ResponseBody
    public String addRoute(RouteInfo routeInfo){

        int flag = transportService.addRoute(routeInfo);
        if(flag > 0){
            return "success";
        }else{
            return "failure";
        }
    }
}
