package com.bittereggs.admin_8009.controller;

import com.bittereggs.admin_8009.entity.Blacklist;
import com.bittereggs.admin_8009.service.BlacklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlacklistController {

    @Autowired
    private BlacklistService blacklistService;

    @PostMapping("/getblacklist")
    public String getBlackList(@RequestBody Blacklist blacklist){
        String res = blacklistService.getBlackList(blacklist);
        return res;
    }

    @PostMapping("/addblacklist")
    public String addBlackList(@RequestBody Blacklist blacklist){
        String res = blacklistService.addBlackList(blacklist);
        return res;
    }

    @GetMapping("/delblacklist")
    public String delBlackList(@RequestParam("name") String name){
        String res = blacklistService.delBlackList(name);
        return res;
    }


}
