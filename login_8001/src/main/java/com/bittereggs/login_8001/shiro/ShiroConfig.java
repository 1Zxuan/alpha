package com.bittereggs.login_8001.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    /*
     * 创建ShiroFilterFactoryBean
     * */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securiManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securiManager);
        //添加shiro内置过滤器
            /*
            shiro内置过滤器可以实现权限相关的拦截器
            anon ：无须认证（登录）可以访问
            authc:必须认证才可以访问
            user:如果使用rememberMe的功能可以直接访问
            perms:该资源必须得到资源权限才可以访问
            role：该资源必须得到角色权限才可以访问
             */
        Map<String,String> filterMap = new LinkedHashMap<>();
        filterMap.put("/testThymeleaf","anon");
        //放行login.html页面
        filterMap.put("/login","anon");
        //授权过滤器
        //注意：当前授权拦截后，shiro会自动跳转到未授权页面
       // filterMap.put("/add","perms[user:add]");
        //filterMap.put("/*","authc");
        //修改跳转的登录页面
        shiroFilterFactoryBean.setLoginUrl("/tologin");
        //设置未授权提示页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/noAuth");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }
    /*
     * 创建DefaultWebSecurityManager
     * */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("Realm") Realm realm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联realm
        securityManager.setRealm(realm);
        return securityManager;
    }

    /*
     * 创建Realm
     * */
    @Bean(name = "Realm")
    public Realm getRealm(){
        return new Realm();
    }
}


