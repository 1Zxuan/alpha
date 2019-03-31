package com.alpha.findinfromatin_8003.controller;



import com.alpha.findinfromatin_8003.service.FindInfomationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FindInformationController {

    @Autowired
    private FindInfomationService findInfomationService;

    //通过工作室名称获取所有信息
    @GetMapping("/getworkroom")
    public String getWorkRoom(@RequestParam(name = "workroom_username") String workroom_username){
        String res = findInfomationService.getWorkRoom(workroom_username);
        return res;

    }
    //通过企业名称获取所有信息
    @GetMapping("/getenterprise")
    public String getEnterprise(@RequestParam("company_username") String company_username){
        String res =findInfomationService.getEnterprise(company_username);
        return res;

    }

    //获取全部工作室信息
    @GetMapping("/getallworkroom")
    public String getAllWorkRoom(@RequestParam(name = "page") String page){
        String res = findInfomationService.getAllWorkRoom(page);
        return res;
    }
    //查询工作室（模糊）
    @GetMapping("/searchworkroom")
    public String searchWorkRoom(@RequestParam(name = "key") String key){
        String res= findInfomationService.searchWorkRoom(key);
        return res;

    }


}
