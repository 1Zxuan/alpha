package com.bittereggs.admin_8009.controller;

import com.bittereggs.admin_8009.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/getworkroomaud")
    public String getWorkRoomAud(@RequestParam("status") String status){
        String res = adminService.getWorkRoomAud(status);
        return res;
    }

    @GetMapping("/getenterpriseaud")
    public String getEnterpriseAud(@RequestParam("status") String status){
        String res = adminService.getEnterpriseAud(status);
        return res;
    }
}
