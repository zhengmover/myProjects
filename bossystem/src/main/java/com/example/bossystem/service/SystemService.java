package com.example.bossystem.service;


import com.example.bossystem.pojo.Dept;
import com.example.bossystem.pojo.Emp;


import java.util.List;

public interface SystemService {
    //获取所有部门信息
    public List<Dept> getAllDept();

    //对部门信息进行修改
    public int modifyDept(Dept dept);

    //删除对应部门
    public int delDept(Integer deptid);

    //新增部门
    public int addDept(Dept dept);

    //获取所有员工信息
    public List<Emp> getAllEmp();

    //根据员工id删除员工
    public int delEmp(Integer empid);

    //根据员工号进行更新
    public int updateEmp(Emp emp);

    //新增员工
    public int addEmp(Emp emp);


}
