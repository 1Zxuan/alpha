package com.bittereggs.admin_8009.controller;

import com.bittereggs.admin_8009.entity.Appeal;
import com.bittereggs.admin_8009.service.AppealService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppealController {

    @Autowired
    private AppealService appealService;

    @PostMapping("/getappeal")
    public String getAppeal(@RequestBody Appeal appeal){
        String res = appealService.getAppeal(appeal);
        return res;
    }
    @PostMapping("/addappeal")
    public String addAppeal(@RequestBody Appeal appeal){
        String res = appealService.addAppeal(appeal);
        return res;
    }
    @PostMapping("/upappeal")
    public String upAppeal(@RequestBody Appeal appeal){
        String res = appealService.upAppeal(appeal);
        return res;
    }


}
