package com.alpha.fillinformation_8004.controller;

import com.alpha.fillinformation_8004.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.alpha.fillinformation_8004.service.fillInformationService;

@RestController
public class fillInformationController {
    @Autowired
    private fillInformationService fillInformationService;

    //填写企业信息(审核)
    @PostMapping("/fillenterpriseauditing")
    public String fillEnterpriseAuditing(@RequestBody Enterprise_info_auditing enterpriseInfoAuditing){
        return fillInformationService.fillEnterpriseAuditing(enterpriseInfoAuditing);
    }

    //填写工作室信息(审核)
    @PostMapping("/fillworkroomauditing")
    public String fillWorkroomAuditing(@RequestBody WorkRoom_info_auditing workRoomInfoauditing){
        System.out.println(workRoomInfoauditing);
        return fillInformationService.fillWorkroomAuditing(workRoomInfoauditing);
    }

    //修改用户基本信息
    @PostMapping("/upuserinfo")
    public String upUserInfo(@RequestBody User user){
        System.out.println(user.toString());
        return fillInformationService.upUserInfo(user);
    }
}
