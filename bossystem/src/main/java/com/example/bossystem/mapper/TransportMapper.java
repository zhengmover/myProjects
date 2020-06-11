package com.example.bossystem.mapper;


import com.example.bossystem.pojo.Car;
import com.example.bossystem.pojo.RouteInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.RouteMatcher;

import java.util.List;

@Mapper
@Repository
public interface TransportMapper {

    //获取所有车辆信息
    public List<Car> getAllCars();

    //更新车辆信息
    public int updateCar(Car car);

    //删除车辆信息
    public int delCar(Integer carid);

    //新增车辆信息
    public int addCar(Car car);

    //获取可使用的车辆信息
    public List<Car> getUsableCars();

    //根据车辆id获取对应车辆信息
    public Car getCarById(Integer id);

    //获取所有路线信息
    public List<RouteInfo> getAllRoutes();

    //删除对应的路线
    public int delRoute(Integer rid);

    //更新路线信息
    public int updateRoute(RouteInfo routeInfo);

    //新增路线信息
    public int addRoute(RouteInfo routeInfo);

    //根据目的地查找路线信息
    public RouteInfo getRouteInfoByEnd(String end);
}
