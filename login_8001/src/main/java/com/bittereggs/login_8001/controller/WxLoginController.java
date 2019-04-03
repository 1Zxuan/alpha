package com.bittereggs.login_8001.controller;

import com.bittereggs.login_8001.mapper.WxUserConstant;
import com.bittereggs.login_8001.service.WxLoginService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class WxLoginController implements WxUserConstant {



    @Autowired
    private WxLoginService wxLoginService;



//    @RequestMapping(method = RequestMethod.GET,value = "/wxlogin",consumes = "application/json")
//    public String wxlogin(String code){
//        System.out.println(code);
//        System.out.println("success");
//        return null;
//    }

    @RequestMapping(method = RequestMethod.POST,value = "/wxlogin",consumes = "application/json")
    public Map<String,Object> wxlogin(@RequestBody JSONObject jsonObject){
        System.out.println("ssssssss");
        String code = jsonObject.get("code").toString();
        this.wxLoginService.wxlogin(code);
        Map<String,Object> map = new HashMap<>();
        //判断缓存中是否存在用户信息
        map.put("msg",true);
        return map;
    }
    
    @RequestMapping(method = RequestMethod.POST,value = "/test")
    public String test(){
        System.out.println("test");
        Map<String,Object> map = new HashMap<>();
        //判断缓存中是否存在用户信息
        map.put("msg",true);
        JSONArray j = JSONArray.fromObject(map);
        return j.toString();
    }


}
