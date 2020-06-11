package com.example.bossystem.Config;


import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    //ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(defaultWebSecurityManager);

        /*
         * anon:无需认证就可以访问
         * authc:必须认证才能访问
         * user:必须拥有记住我功能才能用
         * perms:拥有对某个资源的权限才能访问
         * role:拥有某个角色权限才能访问
         *
         * */
        //添加Shiro的内置过滤器
        Map<String,String> filterMap = new LinkedHashMap<>();
        //设置允许访问的资源
//        filterMap.put("/user/buyGoods","anon");
        filterMap.put("/toRegister","anon");
        filterMap.put("/register","anon");
        filterMap.put("/toIndex","anon");
        filterMap.put("/toLogin","anon");
        filterMap.put("/logout","anon");
        filterMap.put("/","anon");

//        //设置注销用户操作
//        filterMap.put("/logout","logout");
        //设置普通客户访问的页面
        filterMap.put("/user/*","roles[user]");
        //设置系统管理员访问的界面
        filterMap.put("/admin/*","roles[admin]");
        //访问资源设置验证
        filterMap.put("/*","authc");

        bean.setFilterChainDefinitionMap(filterMap);

        //如果未登录就试图访问资源路径，设置登录的请求
        bean.setLoginUrl("/toLogin");

        //设置未授权提示页面(用户和管理员)
        bean.setUnauthorizedUrl("/unAuth");
        return bean;

    }

    //DefaultWebSecurityManager
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //关联UserReaml
        defaultWebSecurityManager.setRealm(userRealm);
        return defaultWebSecurityManager;
    }

    //创建reaml对象，需要自定义类
    @Bean
    public UserRealm userRealm(){
        return new UserRealm();
    }
}
