package com.bittereggs.admin_8009.controller;

import com.bittereggs.admin_8009.entity.Appeal;
import com.bittereggs.admin_8009.service.AppealService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppealController {

    @Autowired
    private AppealService appealService;

    @GetMapping("/  ")
    public String getAppeal(@RequestBody Appeal appeal){
        String res = appealService.getAppeal(appeal);
        return res;
    }


}
