package com.example.bossystem.controller;


import com.example.bossystem.pojo.Dept;
import com.example.bossystem.pojo.Emp;
import com.example.bossystem.pojo.CompanyInfo;
import com.example.bossystem.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class SystemController {

    @Autowired
    SystemService systemService;

    @Autowired
    CompanyInfo info;

    @RequestMapping("/admin/deptManage")//跳转到显示部门信息
    public String showDept(Model model){

        //得到所有部门信息
        List<Dept> depts = systemService.getAllDept();

        model.addAttribute("depts",depts);
        return "admin/dept";
    }

    @RequestMapping("/admin/deptModify")
    @ResponseBody//执行对部门表更新操作
    public String modifyDept(Dept dept){
        int flag = systemService.modifyDept(dept);//得到数据库更新操作的返回值
        if(flag > 0){
            return "success";//更新成功，返回success，否则返回failure
        }else{
            return "failure";
        }

    }

    //删除部门
    @RequestMapping(value = "/admin/deptDel/{deptid}",method = RequestMethod.GET)
    @ResponseBody
    public String delDept(@PathVariable("deptid")Integer deptid){
        int flag = systemService.delDept(deptid);
        if(flag > 0){//如果删除成功，则返回success；否则返回failure
            return "success";
        }else{
            return "failure";
        }

    }

    //添加部门
    @RequestMapping("/admin/deptAdd")
    @ResponseBody
    public String addDept(Dept dept){
        int flag = systemService.addDept(dept);
        if(flag > 0){//如果添加成功，则返回success；否则返回failure
            return "success";
        }else{
            return "failure";
        }
    }

    //显示所有员工信息
    @RequestMapping("/admin/empManage")
    public String showEmp(Model model){
        //查询所有员工信息
        List<Emp> emps = systemService.getAllEmp();
        //获取所有的部门信息
        List<Dept> depts = systemService.getAllDept();
        model.addAttribute("emps",emps);
        model.addAttribute("depts",depts);
        return "admin/emp";
    }

    //删除员工
    @RequestMapping("/admin/empDel/{empid}")
    @ResponseBody
    public String delEmp(@PathVariable("empid") Integer empid){
        int flag = systemService.delEmp(empid);
        if(flag > 0){//如果删除成功，则返回success；否则返回failure
            return "success";
        }else{
            return "failure";
        }
    }

    //更新员工信息
    @RequestMapping("/admin/updateEmp")
    @ResponseBody
    public String updateEmp(Emp emp){

        int flag = systemService.updateEmp(emp);
        if(flag > 0){//如果更新成功，则返回success；否则返回failure
            return "success";
        }else{
            return "failure";
        }
    }

    @RequestMapping("/admin/addEmp")
    @ResponseBody
    public String addEmp(Emp emp){
        int flag = systemService.addEmp(emp);
        if(flag > 0){//如果添加成功，则返回success；否则返回failure
            return "success";
        }else{
            return "failure";
        }
    }


    @RequestMapping("/admin/companyManage")
    public String showCompanyInfo(Model model){

        Map<String,Object> map = new HashMap<>();
        map.put("name",info.getName());//从properties文件读取公司名
        map.put("time",info.getTime());//从properties文件读取公司注册时间
        map.put("business",info.getBusiness());//从properties文件读取公司主营业务
        map.put("address",info.getAddress());//读取公司地址
        map.put("depict",info.getDepict());//读取公司描述
        model.addAllAttributes(map);
        return "admin/companyInfo";
    }
}
