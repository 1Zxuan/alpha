package com.bittereggs.login_8001.mapper;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 楼中煊
 * @data 2019/3/26
 * @time 16:06
 */

@FeignClient(name = "EMAIL-PHONE-8002")
public interface EmailPhoneService {

    @GetMapping("/sendmail")
    String sendmail(@RequestParam("sendmail") String sendmail);

    @GetMapping("/sendphone")
    String sendphone(@RequestParam("sendphone") String sendphone);
}
