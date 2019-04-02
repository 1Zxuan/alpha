package com.bittereggs.money.service.impl;

import com.bittereggs.money.entity.Transaction;
import com.bittereggs.money.mapper.MoneyMapper;
import com.bittereggs.money.service.MoneyService;
import net.sf.json.JSONObject;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 楼中煊
 * @data 2019/3/30
 * @time 16:54
 */

@Service
public class MoneyServiceImpl implements MoneyService {

    @Autowired
    private MoneyMapper moneyMapper;

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

    private Boolean checkpaypassword(String username, String paypassword){
        return moneyMapper.checkpaypassword(username, String.valueOf(DigestUtils.md5Hex(paypassword)));
    }

    private Double seleectadminbalance(){
        return this.moneyMapper.selectadminbalance();
    }
}
