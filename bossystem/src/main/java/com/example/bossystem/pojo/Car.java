package com.example.bossystem.pojo;

public class Car {

    private Integer car_id;//唯一地标识一辆车
    private String car_type;//车辆型号
    private String car_num;//车牌号
    private Integer traffic;//最大载重量(/箱)
    private Integer used_traffic;//已使用的载重量(/箱)
    private Integer car_status;//车辆状态(0表示维修中，1表示已出车，2表示可使用)
    private String dname;//对应的司机姓名

    @Override
    public String toString() {
        return "Car{" +
                "car_id=" + car_id +
                ", car_type='" + car_type + '\'' +
                ", car_num='" + car_num + '\'' +
                ", traffic=" + traffic +
                ", used_traffic=" + used_traffic +
                ", car_status=" + car_status +
                '}';
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public Integer getUsed_traffic() {
        return used_traffic;
    }

    public void setUsed_traffic(Integer used_traffic) {
        this.used_traffic = used_traffic;
    }

    public Integer getCar_status() {
        return car_status;
    }

    public void setCar_status(Integer car_status) {
        this.car_status = car_status;
    }

    public Integer getCar_id() {
        return car_id;
    }

    public void setCar_id(Integer car_id) {
        this.car_id = car_id;
    }

    public String getCar_type() {
        return car_type;
    }

    public void setCar_type(String car_type) {
        this.car_type = car_type;
    }

    public String getCar_num() {
        return car_num;
    }

    public void setCar_num(String car_num) {
        this.car_num = car_num;
    }

    public Integer getTraffic() {
        return traffic;
    }

    public void setTraffic(Integer traffic) {
        this.traffic = traffic;
    }
}
