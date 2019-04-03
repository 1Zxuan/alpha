package com.bittereggs.money.controller;

import com.bittereggs.money.entity.Advertisement;
import com.bittereggs.money.service.ADService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 楼中煊
 * @data 2019/4/1
 * @time 19:54
 */

@RestController
public class ADController {

    @Autowired
    private ADService adService;

    //工作申请广告位

    @PostMapping("/workroomapplyAD")
    public String workroomapplyAD(@RequestBody Advertisement advertisement){
        return adService.workroomapplyAD(advertisement);
    }

    @PostMapping("/companyapplyAD")
    public String companyapplyAD(@RequestBody Advertisement advertisement){
        return adService.companyapplyAD(advertisement);
    }

}
