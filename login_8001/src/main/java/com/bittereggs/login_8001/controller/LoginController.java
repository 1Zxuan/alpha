package com.bittereggs.login_8001.controller;

import com.bittereggs.login_8001.config.RedisHelper;
import com.bittereggs.login_8001.entity.User;
import com.bittereggs.login_8001.service.LoginService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class LoginController {

    private final static Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;

    @Autowired
    private RedisHelper redisHelper;

    //注册
    @RequestMapping(method = RequestMethod.POST,value = "/register",consumes = "application/json")
    public String register(@RequestBody User user){
        redisHelper.hashPut("UserList",user.getUsername(),user.toString());
        Map<String,Object> map = new HashMap<>();
        map.put("message",true);
        JSONArray jsonArray = JSONArray.fromObject(map);
        return jsonArray.toString();
    }

    //登录
    @RequestMapping(method = RequestMethod.POST,value = "/login",consumes = "application/json")
    public String login(@RequestBody User user){
       // System.out.println(redisHelper.hashFindAll("UserList").get(user.getUsername()));
        JSONObject jsonObject = JSONObject.fromObject(redisHelper.hashFindAll("UserList").get(user.getUsername()));
        System.out.println(jsonObject);
        User user1 = (User) JSONObject.toBean(jsonObject,User.class);
        if(user1 == null){
            System.out.println("用户不存在");
        }else if(user1 != null && !user.getPassword().equals(user1.getPassword())){
            System.out.println("密码错误");
        }else {
            System.out.println("可以登录");
        }
        return null;
    }

    @ResponseBody
    @PostMapping("/test")
    public String test(){
        return "test";
    }
}
