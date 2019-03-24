package com.bittereggs.email_phone_8002.util;

import net.sf.json.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SendSMS {

    private static String Url = "http://106.ihuyi.cn/webservice/sms.php?method=Submit";

    public String send(String phone){
        HttpClient client = new HttpClient();
        PostMethod method = new PostMethod(Url);
        Map<String,Object> re = new HashMap<>();
        client.getParams().setContentCharset("GBK");
        method.setRequestHeader("ContentType","application/x-www-form-urlencoded;charset=GBK");
        int mobile_code = (int)((Math.random()*9+1)*100000);
        String content = new String("您的验证码是：" + mobile_code + "。请不要把验证码泄露给其他人。");
        NameValuePair[] data ={
                new NameValuePair("account","C90828810"),
                new NameValuePair("password", "3908acb8e6c476589a5337583b8b488d"),  //查看密码请登录用户中心->验证码短信->产品总览->APIKEY
                //new NameValuePair("password", util.StringUtil.MD5Encode("密码")),
                new NameValuePair("mobile", phone),
                new NameValuePair("content", content),
        };
        method.setRequestBody(data);

        try {
            client.executeMethod(method);
            String submitResult = method.getResponseBodyAsString();
            Document document = DocumentHelper.parseText(submitResult);
            Element root = document.getRootElement();
            String code = root.elementText("code");
            String msg = root.elementText("msg");
            String smsid = root.elementText("smsid");
            if(code.equals("2")){
                System.out.println("短信提交成功");
            }
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }finally {
            method.releaseConnection();
            client.getHttpConnectionManager().closeIdleConnections(0);
        }
        re.put("yzm",mobile_code);
        JSONObject jsonObject = JSONObject.fromObject(re);
        return jsonObject.toString();
    }
}
