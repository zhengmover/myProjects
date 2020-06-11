package com.example.bossystem.service.impl;

import com.example.bossystem.mapper.GoodsMapper;
import com.example.bossystem.mapper.TransportMapper;
import com.example.bossystem.pojo.Car;
import com.example.bossystem.pojo.RouteInfo;
import com.example.bossystem.service.TransportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class TransportServiceImpl implements TransportService {

    @Autowired
    TransportMapper transportMapper;
    @Autowired
    GoodsMapper goodsMapper;


    //获取所有车辆信息
    public List<Car> getAllCars() {

        List<Car> cars = transportMapper.getAllCars();
        return cars;
    }

    //更新车辆信息
    public int updateCar(Car car) {
        int flag = transportMapper.updateCar(car);
        if(flag > 0){
            return 1;
        }else{
            return 0;
        }

    }

//    删除车辆信息
    public int delCar(Integer carid) {
        int flag = transportMapper.delCar(carid);
        if(flag > 0){
            return 1;
        }else{
            return 0;
        }


    }

    //新增车辆信息
    public int addCar(Car car) {
        int flag = transportMapper.addCar(car);
        if(flag > 0){
            return 1;
        }else{
            return 0;
        }

    }

    //获取可使用的且容量足够车辆信息
    public List<Car> getUsableCars(Integer order_no) {
        //获取可使用的车辆信息
        List<Car> cars = transportMapper.getUsableCars();
        List<Car> suitableCars = new LinkedList<>();
        //获取要处理的订单的箱数
        int count = goodsMapper.getGoodsCountByOrderNo(order_no);
        for (Car car : cars){
            int size = car.getTraffic() - car.getUsed_traffic();//车辆剩余的容积
            if(size >= count){//如果能装车
                suitableCars.add(car);
            }
        }
        return suitableCars;
    }

    //获取所有路线信息
    public List<RouteInfo> getAllRoutes() {
        List<RouteInfo> infos = transportMapper.getAllRoutes();
        return infos;
    }

    //删除对应的路线
    public int delRoute(Integer rid) {

        int flag = transportMapper.delRoute(rid);
        if(flag > 0){
            return 1;
        }else{
            return 0;
        }
    }

    //更新路线信息
    public int updateRoute(RouteInfo routeInfo) {
        int flag = transportMapper.updateRoute(routeInfo);
        if(flag > 0){
            return 1;
        }else{
            return 0;
        }
    }

    //新增路线信息
    public int addRoute(RouteInfo routeInfo) {
        //如果存在同样的路线
        if(transportMapper.getRouteInfoByEnd(routeInfo.getEnd()) != null){
            return 0;
        }

        int flag = transportMapper.addRoute(routeInfo);
        if(flag > 0){
            return 1;
        }else{
            return 0;
        }
    }


}
