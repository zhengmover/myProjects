package com.example.bossystem.service;

import com.example.bossystem.pojo.Car;
import com.example.bossystem.pojo.RouteInfo;

import java.util.List;

public interface TransportService {

    //获取所有车辆信息
    public List<Car> getAllCars();

    //更新车辆信息
    public int updateCar(Car car);

    //删除车辆信息
    public int delCar(Integer carid);

    //新增车辆信息
    public int addCar(Car car);

    //获取可使用的且容量足够车辆信息
    public List<Car> getUsableCars(Integer order_no);

    //获取所有路线信息
    public List<RouteInfo> getAllRoutes();

    //删除对应的路线
    public int delRoute(Integer rid);

    //更新路线信息
    public int updateRoute(RouteInfo routeInfo);

    //新增路线信息
    public int addRoute(RouteInfo routeInfo);
}
