package com.alpha.findinfromatin_8003.controller;


import com.alpha.findinfromatin_8003.entity.BiddingBook;
import com.alpha.findinfromatin_8003.entity.WorkRoom;
import com.alpha.findinfromatin_8003.service.FindInfomationService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    //  通过招标书名字获取全部信息
    @GetMapping("/getbiddingbook")
    public String getBiddingBook(@RequestParam(name = "bidding_name") String bidding_name){
        BiddingBook biddingBook =findInfomationService.getBiddingBook(bidding_name);
        return biddingBook.toString();
    }
    //  获取全部招标书名字
    @GetMapping("/getallbiddingbook")
    public String getAllBiddingBook(@RequestParam(name = "page")String page,@RequestParam(name = "order") String order ){
        List<BiddingBook> list=findInfomationService.getAllBiddingBook(page,order);

        //JSONObject json = JSONObject.fromObject(list);
        //System.out.println(json.toString());
        return list.toString();
    }
    //获取全部工作室信息
    @GetMapping("/getallworkroom")
    //@RequestMapping(method = RequestMethod.GET,path = "/getallworkroom",consumes = "application/json")
    public String getAllWorkRoom(@RequestParam(name = "page") String page){
        List<WorkRoom> list= findInfomationService.getAllWorkRoom(page);
        /*for(int i = 0;i < list.size();i++){
            System.out.println(list.get(i));
        }*/
        JSONArray json = JSONArray.fromObject(list);
        return json.toString();
    }
    //查询工作室（模糊）/////////////(根据什么来查询)/**/
    @GetMapping("/searchworkroom")
    public String searchWorkRoom(@RequestParam(name = "key") String key){
        List<WorkRoom> list= findInfomationService.searchWorkRoom(key);
        return list.toString();
    }


}
