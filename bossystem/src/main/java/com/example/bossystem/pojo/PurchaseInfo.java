package com.example.bossystem.pojo;

public class PurchaseInfo {

    private Integer id;
    private Integer gid;//标识对应的水果种类
    private String gname;//对应的水果名称
    private Integer num;//进货的箱数
    private Integer sid;//对应的供应商id
    private String name;//对应的供应商名称
    private String handler;//处理人
    private Integer sex;//处理人性别(0为男，1为女)

    @Override
    public String toString() {
        return "PurchaseInfo{" +
                "id=" + id +
                ", gid=" + gid +
                ", gname='" + gname + '\'' +
                ", num=" + num +
                ", sid=" + sid +
                ", name='" + name + '\'' +
                ", handler='" + handler + '\'' +
                ", sex=" + sex +
                '}';
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
