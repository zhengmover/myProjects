package com.example.bossystem.controller;


import com.example.bossystem.pojo.Car;
import com.example.bossystem.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller//与运输有关的事务控制器
public class TransportController {

    @Autowired
    TransportService transportService;

    //展示所有卡车信息
    @RequestMapping("/admin/carManage")
    public String showCars(Model model){
        List<Car> cars = transportService.getAllCars();
        model.addAttribute("cars",cars);
        return "admin/car";
    }

    @RequestMapping("/admin/updateCar")
    @ResponseBody
    public String updateCar(Car car){
        int flag = transportService.updateCar(car);

        if(flag > 0){
            return "success";
        }else{
            return "failure";
        }
    }

    @RequestMapping("/admin/delCar/{carid}")
    @ResponseBody
    public String delCar(@PathVariable("carid") Integer carid){
        int flag = transportService.delCar(carid);
        if(flag > 0){
            return "success";
        }else{
            return "failure";
        }

    }

    @RequestMapping("/admin/addCar")
    @ResponseBody
    public String addCar(Car car){
        int flag = transportService.addCar(car);
        if(flag > 0){
            return "success";
        }else{
            return "failure";
        }
    }
}
