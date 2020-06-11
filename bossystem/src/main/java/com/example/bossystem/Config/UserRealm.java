package com.example.bossystem.Config;

import com.example.bossystem.pojo.Authority;
import com.example.bossystem.pojo.User;
import com.example.bossystem.service.LoginService;
import com.example.bossystem.service.PermService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;


//自定义的UserRealm
public class UserRealm extends AuthorizingRealm {


    @Autowired
    LoginService loginService;

    @Autowired
    PermService permService;

    @Autowired
    User user ;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        //根据登录时的用户，赋予对应的角色权限
        Authority authority = permService.getAuthByUid(user.getUid());
//        System.out.println("权限为"+authority.getAuth());
        if(authority.getAuth() == 1){
            info.addRole("admin");//权限为1，为管理员
        }else{
            info.addRole("user");//权限为0，为普通用户
        }

        return info;
    }


    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        //用户名，密码  数据库中取
        UsernamePasswordToken userToken = (UsernamePasswordToken) token;
        //连接真实的数据库
        user = loginService.getUserByName(userToken.getUsername());
        if(user==null){//没有这个人
            return null;//返回用户错误
        }

        //密码认证，shiro做，加密了~
        return new SimpleAuthenticationInfo("",user.getUpwd(),"");
    }
}
