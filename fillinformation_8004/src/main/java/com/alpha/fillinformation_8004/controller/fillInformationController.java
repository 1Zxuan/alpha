package com.alpha.fillinformation_8004.controller;

import com.alpha.fillinformation_8004.entity.Enterprise;
import com.alpha.fillinformation_8004.entity.WorkRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.alpha.fillinformation_8004.service.fillInformationService;

@RestController
public class fillInformationController {
    @Autowired
    private fillInformationService fillInformationService;
    //完善企业信息
    @PostMapping("/fillenterprise")
    public String fillenterprise(@RequestBody Enterprise enterprise){
        System.out.println(enterprise.toString());
        return fillInformationService.fillenterprise(enterprise);
    }
    //完善工作室
    @PostMapping("/fillworkroom")
    public String fillworkroom(@RequestBody WorkRoom workRoom){
        System.out.println(workRoom.toString());
        return fillInformationService.fillworkroom(workRoom);


    }
}
