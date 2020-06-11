package com.example.bossystem.pojo;

import org.springframework.stereotype.Component;

@Component
public class UserBuyInfo {//表示用户一次购买的商品的信息
    private Integer id;
    private Integer user_id;//购买用户的id
    private String gname;//购买商品的名称
    private Integer gcount;//购买的数量
    private Integer order_no;//所属的订单编号
    private String gpath;//图片存储路径

    public String getGpath() {
        return gpath;
    }

    public void setGpath(String gpath) {
        this.gpath = gpath;
    }

    @Override
    public String toString() {
        return "UserBuyInfo{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", gname='" + gname + '\'' +
                ", gcount=" + gcount +
                ", order_no=" + order_no +
                ", gpath='" + gpath + '\'' +
                '}';
    }

    public Integer getOrder_no() {
        return order_no;
    }

    public void setOrder_no(Integer order_no) {
        this.order_no = order_no;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public Integer getGcount() {
        return gcount;
    }

    public void setGcount(Integer gcount) {
        this.gcount = gcount;
    }
}
