package com.bittereggs.email_phone_8002.service.impl;

import com.bittereggs.email_phone_8002.service.MailService;
import com.bittereggs.email_phone_8002.util.SendSMS;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MailServiceImpl implements MailService {



    @Autowired
    JavaMailSenderImpl mailSender;
    public String random() {
//        int ran = (int) Math.random() * 9000 + 1000;
//        return String.valueOf(ran);
        String randomcode = "";
        String model = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] m = model.toCharArray();
        for (int j = 0; j < 6; j++) {
            char c = m[(int) (Math.random() * 36)];
            // 保证六位随机数之间没有重复的
            if (randomcode.contains(String.valueOf(c))) {
                j--;
                continue;
            }
            randomcode = randomcode + c;
        }
        return randomcode;
    }

    public void contextLoads(String s,String sendmail) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setSubject("bittereggs客服");//标题
        mailMessage.setText(s);//内容
        mailMessage.setTo(sendmail);//目标邮箱
        mailMessage.setFrom("64390357@qq.com");//发件邮箱
        mailSender.send(mailMessage);
    }

    public String sendmail(String sendmail){
        String s=random();
        contextLoads(s,sendmail);
        Map<String,Object> map = new HashMap<>();
        map.put("yzm",s);
        JSONArray jsonArray = JSONArray.fromObject(map);
        return jsonArray.toString();
    }

    @Override
    public String sendphone(String phone) {
        SendSMS sendSMS = new SendSMS();
        return sendSMS.send(phone);
    }


}
