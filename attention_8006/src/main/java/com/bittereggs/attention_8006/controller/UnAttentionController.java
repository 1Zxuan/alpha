package com.bittereggs.attention_8006.controller;

import com.bittereggs.attention_8006.service.UnAttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 楼中煊
 * @data 2019/3/24
 * @time 14:12
 */

@RestController
public class UnAttentionController {

    @Autowired
    private UnAttentionService unAttentionService;

    @GetMapping("/companycancelworkroom")
    public String companycancelworkroom(@RequestParam("company")String company,
                                        @RequestParam("workroom")String workroom){
        this.unAttentionService.companycancelworkroom(company,workroom);
        return null;
    }

    @GetMapping("/workroomcancelcompany")
    public String workroomcancelcompany(@RequestParam("company")String company,
                                        @RequestParam("workroom")String workroom){
        this.unAttentionService.workroomcancelcompany(company,workroom);
        return null;
    }

}
