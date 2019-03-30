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
        String res = fillInformationService.fillEnterpriseAuditing(enterpriseInfoAuditing);
        return res;
    }

    //填写工作室信息(审核)
    @PostMapping("/fillworkroomauditing")
    public String fillWorkroomAuditing(@RequestBody WorkRoom_info_auditing workRoomInfoauditing){
        String res = fillInformationService.fillWorkroomAuditing(workRoomInfoauditing);
        return res;
    }

    //修改用户基本信息
    @PostMapping("/upuserinfo")
    public String upUserInfo(@RequestBody User user){
        String res = fillInformationService.upUserInfo(user);
        return res;
    }
}
