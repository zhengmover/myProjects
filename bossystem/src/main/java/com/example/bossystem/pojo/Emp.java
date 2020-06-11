package com.example.bossystem.pojo;

//员工表
public class Emp {

    private Integer emp_num;//员工id号
    private String emp_name;//员工名
    private String emp_hiredate;//入职时间
    private String emp_tel;//员工联系方式
    private Integer dept_no;//员工所在的部门的部门号
    private String dept_name;//员工所在部门名
    private Integer emp_status;//员工状态(0表示轮休，1表示在岗,2表示运输部的司机可出车)

    @Override
    public String toString() {
        return "Emp{" +
                "emp_num=" + emp_num +
                ", emp_name='" + emp_name + '\'' +
                ", emp_hiredate='" + emp_hiredate + '\'' +
                ", emp_tel='" + emp_tel + '\'' +
                ", dept_no=" + dept_no +
                ", dept_name='" + dept_name + '\'' +
                ", emp_status=" + emp_status +
                '}';
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public Integer getEmp_num() {
        return emp_num;
    }

    public void setEmp_num(Integer emp_num) {
        this.emp_num = emp_num;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmp_hiredate() {
        return emp_hiredate;
    }

    public void setEmp_hiredate(String emp_hiredate) {
        this.emp_hiredate = emp_hiredate;
    }

    public String getEmp_tel() {
        return emp_tel;
    }

    public void setEmp_tel(String emp_tel) {
        this.emp_tel = emp_tel;
    }

    public Integer getDept_no() {
        return dept_no;
    }

    public void setDept_no(Integer dept_no) {
        this.dept_no = dept_no;
    }

    public Integer getEmp_status() {
        return emp_status;
    }

    public void setEmp_status(Integer emp_status) {
        this.emp_status = emp_status;
    }
}
