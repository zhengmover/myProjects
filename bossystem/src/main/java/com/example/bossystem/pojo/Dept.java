package com.example.bossystem.pojo;

public class Dept {

    private Integer dept_id;//部门id
    private String dept_name;//部门名称
    private String depict;//部门描述

    @Override
    public String toString() {
        return "dept{" +
                "dept_id=" + dept_id +
                ", dept_name='" + dept_name + '\'' +
                ", depict='" + depict + '\'' +
                '}';
    }

    public String getDepict() {
        return depict;
    }

    public void setDepict(String depict) {
        this.depict = depict;
    }

    public Integer getDept_id() {
        return dept_id;
    }

    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }
}
