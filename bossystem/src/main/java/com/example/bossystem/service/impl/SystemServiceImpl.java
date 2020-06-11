package com.example.bossystem.service.impl;

import com.example.bossystem.mapper.SystemMapper;
import com.example.bossystem.pojo.Dept;
import com.example.bossystem.pojo.Emp;
import com.example.bossystem.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemServiceImpl implements SystemService {

    @Autowired
    SystemMapper systemMapper;

    //获取所有部门信息
    public List<Dept> getAllDept() {
        return systemMapper.getAllDept();
    }

    //对部门信息进行修改
    public int modifyDept(Dept dept) {
        int flag = systemMapper.modifyDept(dept);
        if(flag == 1){//如果更新成功,返回1；否则返回0
            return 1;
        }else{
            return 0;
        }


    }

    //删除对应部门
    public int delDept(Integer deptid) {
        return systemMapper.delDept(deptid);
    }

    //新增部门
    public int addDept(Dept dept) {
        return systemMapper.addDept(dept);
    }

    //获取所有员工信息
    public List<Emp> getAllEmp() {

        //查询所有员工
        List<Emp> emps = systemMapper.getAllEmp();

        return emps;
    }

    //根据员工id删除员工
    public int delEmp(Integer empid) {
        return systemMapper.delEmp(empid);
    }

    //根据员工号进行更新
    public int updateEmp(Emp emp) {
        if(systemMapper.updateEmp(emp) > 0){
            return 1;
        }else {
            return 0;
        }

    }

    //新增员工
    public int addEmp(Emp emp) {
        int flag = systemMapper.addEmp(emp);
        if(flag > 0){
            return 1;
        }else{
            return 0;
        }

    }



}
