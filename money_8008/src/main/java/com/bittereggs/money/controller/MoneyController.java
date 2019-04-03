package com.bittereggs.money.controller;

import com.bittereggs.money.entity.Advertisement;
import com.bittereggs.money.entity.Transaction;
import com.bittereggs.money.service.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.jar.JarEntry;

/**
 * @author 楼中煊
 * @data 2019/3/30
 * @time 16:50
 */

@RestController
public class MoneyController {

    @Autowired
    private MoneyService moneyService;

    //充值
    @PostMapping("/recharge")
    public String recharge(@RequestBody Transaction transaction){
        return moneyService.recharge(transaction);
    }

    //提现
    @PostMapping("/withdraw")
    public String withdraw(@RequestBody Transaction transaction){
        return moneyService.withdraw(transaction);
    }

    //交易
    @PostMapping("/companypay")
    public String companypay(@RequestBody Transaction transaction){
        return moneyService.companypay(transaction);
    }

    @PostMapping("/workroomreceipt")
    public String workroomreceipt(@RequestBody Transaction transaction){
        return moneyService.workroomreceipt(transaction);
    }

    //发送重置密码手机验证码
    @GetMapping("/getphonerepayyzm")
    public String getphonerepayyzm(@RequestParam("phone")String phone){
        return this.moneyService.getphonerepayyzm(phone);
    }

    @GetMapping("/checkrepayyzm")
    public String checkrepayyzm(@RequestParam("phone")String phone,@RequestParam("yzm")String yzm){
        return moneyService.checkphonerepayyzm(phone,yzm);
    }

    //验证通过后重置支付密码
    @PostMapping("/resetpaypassword")
    public String resetpaypassword(@RequestParam("username")String username,@RequestParam("paypassword")String paypassword){
        return moneyService.resetpaypassword(username,paypassword);
    }



}
