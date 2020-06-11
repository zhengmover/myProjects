package com.example.bossystem.mapper;

import com.example.bossystem.pojo.Dept;
import com.example.bossystem.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//对部门，员工等核心数据库进行操作
@Repository
@Mapper
public interface SystemMapper {

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


    //根据员工id获取员工信息
    public Emp getEmpById(Integer empid);
}
