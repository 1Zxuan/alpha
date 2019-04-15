package com.bittereggs.login_8001.controller;

import com.bittereggs.login_8001.mapper.WxUserConstant;
import com.bittereggs.login_8001.service.WxLoginService;
import javafx.geometry.Pos;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
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

    @RequestMapping(method = RequestMethod.POST, value = "/wxlogin1", consumes = "application/json")
    public Map<String,Object> wxlogin1(@RequestBody JSONObject jsonObject){
        return wxLoginService.wxlogin1(jsonObject);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/wxregister1", consumes = "application/json")
    public Map<String,Object> wxregister1(@RequestBody JSONObject jsonObject){
        return wxLoginService.wxregister1(jsonObject);
    }


    @RequestMapping(method = RequestMethod.POST,value = "/wxlogin",consumes = "application/json")
    public Map<String,Object> wxlogin(@RequestBody JSONObject jsonObject){
        String code = jsonObject.get("code").toString();
        return wxLoginService.wxlogin(code);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/wxregister", consumes = "application/json")
    public Map<String,Object> wxregister(@RequestBody JSONObject jsonObject){
        String phone = jsonObject.getString("phone");
        String yzm = jsonObject.getString("yzm");
        return wxLoginService.wxregister(phone,yzm);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/getwxphoneyzm",consumes = "application/json")
    public Map<String,Object> getwxphoneyzm(@RequestBody JSONObject jsonObject){
        String phone = jsonObject.getString("phone");
        return wxLoginService.getwxphoneyzm(phone);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/checkwxusername",consumes = "application/json")
    public Map<String,Object> checkwxusername(@RequestBody JSONObject jsonObject){
        String username = jsonObject.getString("username");
        return wxLoginService.checkwxusername(username);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/fillinfo", consumes = "application/json")
    public Map<String,Object> fillinfo(@RequestBody JSONObject jsonObject){
        String username = jsonObject.getString("username");
        String password = DigestUtils.md5Hex(jsonObject.getString("password"));
        String phone = jsonObject.getString("phone");
        String type = jsonObject.getString("type");
        String open_id = jsonObject.getString("open_id");
        return wxLoginService.fillinfo(username,password,phone,type,open_id);
    }


    
//    @RequestMapping(method = RequestMethod.POST,value = "/test")
//    public String test(){
//        System.out.println("test");
//        Map<String,Object> map = new HashMap<>();
//        //判断缓存中是否存在用户信息
//        map.put("msg",true);
//        JSONArray j = JSONArray.fromObject(map);
//        return j.toString();
//    }
//

}
