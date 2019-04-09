package com.bittereggs.admin_8009.controller;

import com.bittereggs.admin_8009.entity.User;
import com.bittereggs.admin_8009.service.UserManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserManagerController {

    @Autowired
    private UserManagerService userManagerService;

    @GetMapping("/getuser")
    public String getUser(){
        String res = userManagerService.getUser();
        return res;
    }

    @PostMapping("/upuser")
    public String upUser(@RequestBody User user){
        String res = userManagerService.upUser(user);
        return res;
    }

    @GetMapping("/deluser")
    public String delUser(@RequestParam("username") String username ){
        String res = userManagerService.delUser(username);
        return res;
    }


}
