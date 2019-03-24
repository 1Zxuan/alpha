package com.alpha.findinfromatin_8003.controller;


import com.alpha.findinfromatin_8003.entity.BiddingBook;
import com.alpha.findinfromatin_8003.entity.Enterprise;
import com.alpha.findinfromatin_8003.entity.WorkRoom;
import com.alpha.findinfromatin_8003.service.FindInfomationService;
import com.alpha.findinfromatin_8003.util.JsonDateValueProcessor;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class FindInformationController {
    @Autowired
    private FindInfomationService findInfomationService;
    //通过工作室名称获取所有信息
    //@RequestMapping(method = RequestMethod.GET,path = "/getworkroom",consumes = "application/json")
    @GetMapping("/getworkroom")
    public String getWorkRoom(@RequestParam(name = "workroom_username") String workroom_username){
        WorkRoom workRoom = findInfomationService.getWorkRoom(workroom_username);
        JSONObject json = JSONObject.fromObject(workRoom);
        return json.toString();
    }
    //通过企业名称获取所有信息
    @GetMapping("/getenterprise")
    public String getEnterprise(@RequestParam("company_username") String company_username){
        Enterprise enterprise =findInfomationService.getEnterprise(company_username);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        JSONObject jsonObject = JSONObject.fromObject(enterprise,jsonConfig);
        return jsonObject.toString();
    }
    //  获取全部招标书名字
    @GetMapping("/getallbiddingbook")
    public String getAllBiddingBook(@RequestParam(name = "page")String page,@RequestParam(name = "order") String order ){
        List<BiddingBook> list=findInfomationService.getAllBiddingBook(page,order);
        System.out.println(list.toString());
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        JSONArray jsonArray = JSONArray.fromObject(list,jsonConfig);

    /*    JSONArray json = JSONArray.fromObject(list);
        System.out.println(json.toString());*/
        return jsonArray.toString();
    }

    //获取全部工作室信息
    @GetMapping("/getallworkroom")
    //@RequestMapping(method = RequestMethod.GET,path = "/getallworkroom",consumes = "application/json")
    public String getAllWorkRoom(@RequestParam(name = "page") String page){
        List<WorkRoom> list= findInfomationService.getAllWorkRoom(page);
        /*for(int i = 0;i < list.size();i++){
            System.out.println(list.get(i));
        }*/
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        JSONArray jsonArray = JSONArray.fromObject(list,jsonConfig);
        return jsonArray.toString();
    }
    //查询工作室（模糊）/////////////(根据什么来查询)/**/
    @GetMapping("/searchworkroom")
    public String searchWorkRoom(@RequestParam(name = "key") String key){
        List<WorkRoom> list= findInfomationService.searchWorkRoom(key);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(Date.class, new JsonDateValueProcessor());
        JSONArray jsonArray = JSONArray.fromObject(list,jsonConfig);
        return jsonArray.toString();
    }


}
