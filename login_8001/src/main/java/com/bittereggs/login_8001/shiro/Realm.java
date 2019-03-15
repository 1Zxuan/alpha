package com.bittereggs.login_8001.shiro;

import com.bittereggs.login_8001.config.RedisHelper;
import com.bittereggs.login_8001.entity.User;
import com.bittereggs.login_8001.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class Realm extends AuthorizingRealm {
    //执行授权逻辑
    @Autowired
    private LoginService loginService;

    @Autowired
    private RedisHelper redisHelper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.print("执行授权逻辑");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //info.addStringPermission("user:add");
        //获取当前登录用户
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        System.out.println(user.toString());
//        User dbuser = loginService.findById(user.getID());
        //授权
        info.addStringPermission(user.getType().toString());
        return info;
    }
    //注入业务


    //执行认证逻辑
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg) throws AuthenticationException {
        System.out.print("执行认证逻辑");
        UsernamePasswordToken token = (UsernamePasswordToken) arg;
        User user = loginService.findByName(token.getUsername());
        //System.out.println(user.toString());
        if(user == null)
            return null;
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
    }
}
