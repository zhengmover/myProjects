package com.example.bossystem.pojo;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;


@Component
public class UserOrderInfo {
    private Integer order_no;//订单编号
    private Integer user_id;//订单对应的用户编号
    private double gtotal;//订单总金额
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date order_time;//下单的日期
    private Integer status;//订单状态(0表示待出库，1表示已出库，2表示已接收)
    private String uaddress;//下单地址



    public String getUaddress() {
        return uaddress;
    }

    public void setUaddress(String uaddress) {
        this.uaddress = uaddress;
    }

    public Integer getOrder_no() {
        return order_no;
    }

    public void setOrder_no(Integer order_no) {
        this.order_no = order_no;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public double getGtotal() {
        return gtotal;
    }

    public void setGtotal(double gtotal) {
        this.gtotal = gtotal;
    }

    public Date getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Date order_time) {
        this.order_time = order_time;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


}
