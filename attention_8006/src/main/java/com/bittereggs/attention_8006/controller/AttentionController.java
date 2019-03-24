package com.bittereggs.attention_8006.controller;

import com.bittereggs.attention_8006.service.AttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 楼中煊
 * @data 2019/3/23
 * @time 20:46
 */
@RestController
public class AttentionController {

    @Autowired
    private AttentionService attentionService;

    //公司关注工作室
    @GetMapping("/attentionworkroom")
    public String attentionworkroom(@RequestParam("company")String company, @RequestParam("workroom")String workroom) {
        //判断关注的工作室是否关注该公司
        System.out.println(company+workroom);
        return attentionService.attentionworkroom(company,workroom);
    }

    //工作室关注公司
    @GetMapping("/attentioncompany")
    public String attentioncompany(@RequestParam("company")String company, @RequestParam("workroom")String workroom){

        return attentionService.attentioncompany(company,workroom);
    }

    //查询某企业关注的工作室
    @GetMapping("/companyattention")
    public String companyattention(@RequestParam("company")String company){

        return attentionService.companyattention(company);
    }

    //查询某工作室关注的公司
    @GetMapping("/workroomattention")
    public String workroomattention(@RequestParam("workroom")String workroom){

        return attentionService.workroomattention(workroom);
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }


}
