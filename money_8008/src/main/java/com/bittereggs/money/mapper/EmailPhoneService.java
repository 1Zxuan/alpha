package com.bittereggs.money.mapper;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 楼中煊
 * @data 2019/4/3
 * @time 14:22
 */

@FeignClient(name = "EMAIL-PHONE-8002")
public interface EmailPhoneService {

    @GetMapping("/sendphone")
    String sendphone(@RequestParam("sendphone") String sendphone);
}
