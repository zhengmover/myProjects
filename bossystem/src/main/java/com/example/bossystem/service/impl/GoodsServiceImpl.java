package com.example.bossystem.service.impl;

import com.example.bossystem.mapper.GoodsMapper;
import com.example.bossystem.pojo.*;
import com.example.bossystem.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public List<GoodsInfo> getAllGoodsInfo() {

        //查出所有类别的水果
        List<GoodsInfo> goodsInfos = goodsMapper.getAllGoodsInfo();

        return goodsInfos;
    }

    @Override
    public int updateGoods(Map<Integer, Integer> maps) {
        int flag = goodsMapper.updateGoods(maps);
        if (flag > 0){//如果执行成功
            return 1;
        }else{
        return 0;
    }


}

    @Override//根据水果id查询对应的水果
    public List<GoodsInfo> getGoodByIds(List<Integer> ids) {

        List<GoodsInfo> goods = new LinkedList<>();
        goods = goodsMapper.getGoodByIds(ids);
        return goods;
    }

    @Override
    public int insertToUserBuy(List<UserBuyInfo> goods) {
        if(goodsMapper.insertToUserBuy(goods) > 0){
            return 1;
        }else{
            return 0;
        }

    }


    public int insertToUserOrder(UserOrderInfo userOrderInfo) {
        if(goodsMapper.insertToUserOrder(userOrderInfo) > 0){
            return 1;
        }else {
            return 0;
        }

    }


    public Integer getMaxOrderId() {

        return goodsMapper.getMaxOrderId();
    }

      //获取根据用户id用户所有的订单信息
    public List<UserOrderInfo> getAllUserOrderInfoByUid(Integer uid) {

        List<UserOrderInfo> userOrderInfoList = goodsMapper.getAllUserOrderInfoByUid(uid);
        return userOrderInfoList;
    }

     //根据用户id和订单号查询用户此次购买的商品信息
    public List<UserBuyInfo> getAllUserBuyByUidAndOrderno(Integer uid, Integer order_no) {
        return goodsMapper.getAllUserBuyByUidAndOrderno(uid,order_no);
    }

    //获取一次订单订购对应的箱数
    public int getGoodsCountByOrderNo(Integer order_no) {
        return goodsMapper.getGoodsCountByOrderNo(order_no);
    }

    //根据订单号查询订单
    public UserOrderInfo getUserOrderInfoById(Integer order_no) {
        UserOrderInfo info = goodsMapper.getUserOrderInfoById(order_no);
        return info;
    }

    //用户设置订单已到达
    public int setUserInfoRecv(Integer order_no) {
        if(goodsMapper.setUserInfoRecv(order_no) > 0){
            return 1;
        }else {
            return 0;
        }
    }

    //获取所有供应商信息
    public List<Supplier> getAllSuppliers() {
        return goodsMapper.getAllSuppliers();
    }

    //新增入库货物登记信息
    public int addPurchaseInfo(PurchaseInfo info) {
        //更新已有水果数量
        int flag1 = goodsMapper.addGoods(info.getNum(),info.getGid());
        int flag2 = goodsMapper.addPurchaseInfo(info);
        if((flag1 > 0)&&(flag2 > 0)){
            return 1;
        }else {
            return 0;
        }
    }

    //获取所有的货物登记信息
    public List<PurchaseInfo> getAllPurchaseInfo() {
        List<PurchaseInfo> infos = goodsMapper.getAllPurchaseInfo();

        return infos;
    }


}
