package com.bittereggs.money.service.impl;

import com.bittereggs.money.config.RedisHelper;
import com.bittereggs.money.entity.Transaction;
import com.bittereggs.money.mapper.EmailPhoneService;
import com.bittereggs.money.mapper.MoneyMapper;
import com.bittereggs.money.service.MoneyService;
import net.sf.json.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author 楼中煊
 * @data 2019/3/30
 * @time 16:54
 */

@Service
public class MoneyServiceImpl implements MoneyService {

    @Autowired
    private MoneyMapper moneyMapper;

    @Autowired
    private RedisHelper redisHelper;

    @Autowired
    private EmailPhoneService emailPhoneService;

    @Override
    public String recharge(Transaction transaction) {
        JSONObject result = new JSONObject();
        if (checkpaypassword(transaction.getUsername(),transaction.getPaypassword())){
            moneyMapper.recharge(transaction.getUsername(),Double.valueOf(transaction.getMoney()),"+" + transaction.getMoney(),0);
            result.put("msg","success");
        }
        else {
            result.put("msg","wrong paypassword");
        }
        return result.toString();
    }

    @Override
    public String withdraw(Transaction transaction) {
        JSONObject result = new JSONObject();
        if (checkpaypassword(transaction.getUsername(),transaction.getPaypassword())){
            moneyMapper.withdraw(transaction.getUsername(),Double.valueOf(transaction.getMoney()),"-"+transaction.getMoney(),1);
            result.put("msg","success");
        }else {
            result.put("msg","wrong paypassword");
        }
        return result.toString();
    }

    @Override
    public String companypay(Transaction transaction) {
        JSONObject result = new JSONObject();
        if (checkpaypassword(transaction.getUsername(),transaction.getPaypassword())){
            moneyMapper.companypay(transaction.getUsername(),Double.valueOf(transaction.getMoney()),"-"+transaction.getMoney(),2);
            Double balance = seleectadminbalance()+Double.valueOf(transaction.getMoney());
            this.moneyMapper.adminupdate(balance);
            result.put("msg","success");
        } else {
            result.put("msg","wrong paypassword");
        }
        return result.toString();
    }

    @Override
    public String workroomreceipt(Transaction transaction) {
        JSONObject result = new JSONObject();
        if (checkpaypassword(transaction.getUsername(),transaction.getPaypassword())){
            moneyMapper.workroomreceipt(transaction.getUsername(),Double.valueOf(transaction.getMoney()),"+"+transaction.getMoney(),3);
            Double balance = seleectadminbalance()-Double.valueOf(transaction.getMoney());
            this.moneyMapper.adminupdate(balance);
            result.put("msg","success");
        } else {
            result.put("msg","wrong paypassword");
        }
        return result.toString();
    }

    @Override
    public String getphonerepayyzm(String phone) {
        JSONObject json = new JSONObject();
        try {
            json = JSONObject.fromObject(this.emailPhoneService.sendphone(phone));
            redisHelper.valuePut("ResetPayYzm" + phone,json.get("yzm"));
            redisHelper.expirse("ResetPayYzm" + phone,5, TimeUnit.MINUTES);
            json.remove("yzm");
            json.put("msg","sucess");
        } catch (Exception e){
            json.put("msg","error");
        }
        return json.toString();
    }

    @Override
    public String checkphonerepayyzm(String phone, String yzm) {
        JSONObject json = new JSONObject();
        Object redispayyzm = redisHelper.getValue("ResetPayYzm" + phone);
        if (redispayyzm == null){
            json.put("msg","error");
        } else {
            //验证码存在
            if (yzm.equals(redispayyzm.toString())){
                redisHelper.remove("ResetPayYzm" + phone);
                json.put("msg","success");
            } else {
                json.put("msg","wrong");
            }
        }
        return json.toString();
    }

    @Override
    public String resetpaypassword(String username, String password) {
        JSONObject json = new JSONObject();
        try {
            moneyMapper.resetpaypassword(username,password);
            json.put("msg","success");
        } catch (Exception e){
            json.put("msg","error");
        }
        return json.toString();
    }


    private Boolean checkpaypassword(String username, String paypassword){
        return moneyMapper.checkpaypassword(username, String.valueOf(DigestUtils.md5Hex(paypassword)));
    }

    private Double seleectadminbalance(){
        return this.moneyMapper.selectadminbalance();
    }
}
