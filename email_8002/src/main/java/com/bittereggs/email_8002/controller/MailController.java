package com.bittereggs.email_8002.controller;

import com.bittereggs.email_8002.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

    @Autowired
    private MailService mailService;

    @GetMapping("/sendmail")
    public String t(){
        return mailService.test();
    }
}
