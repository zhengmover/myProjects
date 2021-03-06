package com.example.bossystem.service;

import com.example.bossystem.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface GoodsService {
    //查出所有类别的水果
    public List<GoodsInfo> getAllGoodsInfo();

    //根据商品id,在用户购买后执行对库存的更新
    public int updateGoods(Map<Integer,Integer> maps);

    //根据水果id查询对应的水果
    public List<GoodsInfo> getGoodByIds(List<Integer> ids);

    //将用户此次订单购买的商品存入数据库中
    public int insertToUserBuy(@Param("goods") List<UserBuyInfo> goods);

    //将用户此次订单存入订单表
    public int insertToUserOrder(UserOrderInfo userOrderInfo);

    //查询出订单页面order_no的最大值
    public Integer getMaxOrderId();

    //获取根据用户id用户所有的订单信息
    public List<UserOrderInfo> getAllUserOrderInfoByUid(Integer uid);

    //根据用户id和订单号查询用户此次购买的商品信息
    public List<UserBuyInfo> getAllUserBuyByUidAndOrderno( Integer uid, Integer order_no);

    //获取一次订单订购对应的箱数
    public int getGoodsCountByOrderNo(Integer order_no);

    //根据订单号查询订单
    public UserOrderInfo getUserOrderInfoById(Integer order_no);

    //用户设置订单已到达
    public int setUserInfoRecv(Integer order_no);

    //获取所有供应商信息
    public List<Supplier> getAllSuppliers();

    //新增入库货物登记信息
    public int addPurchaseInfo(PurchaseInfo info);

    //获取所有的货物登记信息
    public List<PurchaseInfo> getAllPurchaseInfo();
}
