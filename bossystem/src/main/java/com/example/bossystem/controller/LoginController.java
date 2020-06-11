package com.example.bossystem.controller;


import com.example.bossystem.mapper.UserMapper;
import com.example.bossystem.pojo.User;
import com.example.bossystem.service.LoginService;
import com.example.bossystem.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @Autowired
    UserService userService;

    //设置登录路径
    @RequestMapping({"/","/toLogin"})
    public String index(){
        return "login";
    }

    //完成注销操作
    @RequestMapping("/logout")
    public String logout(){
        //获取当前的用户
        Subject subject = SecurityUtils.getSubject();
        if(subject != null){//如果当前用户不为空
            subject.logout();//执行注销用户操作
        }
        return "redirect:/login.html";
    }


    //完成未授权检验操作
    @RequestMapping("/unAuth")
    public String unAuth(){
        return "unAuth";
    }


    @RequestMapping("/toIndex")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model,HttpSession session){
        //根据表单传来的数据查询是否存在该用户
       //获取当前的用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户的登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try{
            subject.login(token);//执行登录方法,如果没有异常就说明ok了
            //将登录用户的uid放进session域中，方便后续取出
            User entity =loginService.getUserByName(token.getUsername());
            session.setAttribute("uid",entity.getUid());
            if(token.getUsername().equals("admin")){//如果为管理员登录,进入管理员页面
                return "admin/index";
            }else{
                //如果为普通用户登录，进入用户页面
                //model.addAttribute("user",entity);//登录成功后将用户信息传到主页
                return "user/userBase";
            }

        }catch (UnknownAccountException e){//用户名不存在
            model.addAttribute("msg","用户名错误");
            return "login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");
            return "login";
        }

    }

    @RequestMapping("/toUserMain")
    public String toMain(Model model,HttpSession session){
        int id = Integer.parseInt(session.getAttribute("uid").toString());
        //登录成功后将用户信息传到主页
        User entity = userService.getUserById(id);
        model.addAttribute("user",entity);
        return "user/userHomePage";

    }
    //从登录页面跳转到注册页面
    @GetMapping("/toRegister")
    public String toRegister(){
        return "register";
    }


    //判断是否注册成功,若成功，跳转到登录界面；若失败，返回注册界面
    @PostMapping("/register")
    public String register(User user,Model model){
        //System.out.println("======"+user.getUname());


        if(loginService.insertUser(user)){//如果注册成功，转到登录页
            return "redirect:/login.html";
        }else{
            model.addAttribute("msg","用户名已存在,注册失败");
            //如果失败，则重新注册
            return "register";
        }

    }

}
