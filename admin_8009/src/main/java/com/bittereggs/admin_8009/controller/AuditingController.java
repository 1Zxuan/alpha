package com.bittereggs.admin_8009.controller;

import com.bittereggs.admin_8009.entity.Enterprise_aud;
import com.bittereggs.admin_8009.entity.Workroom_aud;
import com.bittereggs.admin_8009.service.AuditingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuditingController {

    @Autowired
    private AuditingService auditingService;

    @PostMapping("/getworkroomaud")
    public String getWorkroomAud(@RequestBody Workroom_aud workroom_aud){
        String res = auditingService.getWorkroomAud(workroom_aud);
        return res;
    }

    @PostMapping("/getenterpriseaud")
    public String getEnterpriseAud(@RequestBody Enterprise_aud enterprise_aud){
        String res = auditingService.getEnterpriseAud(enterprise_aud);
        return res;
    }

    @PostMapping("/uppassworkroom")
    public String upPassWorkroom(@RequestBody Workroom_aud workroom_aud){
        String res = auditingService.upPassWorkroom(workroom_aud);
        return res;
    }

    @PostMapping("/uppassenterprise")
    public String upPassEnterprise(@RequestBody Enterprise_aud enterprise_aud) {
        String res = auditingService.upPassEnterprise(enterprise_aud);
        return res;
    }


}
