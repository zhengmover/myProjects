package com.example.bossystem.pojo;

//订单处理单
public class HandleInfo {

    private Integer id;//处理单id，主键
    private Integer order_id;//被处理的订单号
    private Integer status;//订单状态
    private String username;//订单对应的用户名
    private Integer car_id;//负责运输的车辆id
    private double pay;//运费
    private String destination;//目的地址
    private String postcode;//目的地邮编
    private String operator;//操作人
    private String dname;//司机姓名
    private String car_num;//对应车牌号

    @Override
    public String toString() {
        return "HandleInfo{" +
                "id=" + id +
                ", order_id=" + order_id +
                ", username='" + username + '\'' +
                ", car_id=" + car_id +
                ", pay=" + pay +
                ", destination='" + destination + '\'' +
                ", postcode='" + postcode + '\'' +
                ", operator='" + operator + '\'' +
                ", dname='" + dname + '\'' +
                '}';
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCar_num() {
        return car_num;
    }

    public void setCar_num(String car_num) {
        this.car_num = car_num;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getCar_id() {
        return car_id;
    }

    public void setCar_id(Integer car_id) {
        this.car_id = car_id;
    }


    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }



    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
