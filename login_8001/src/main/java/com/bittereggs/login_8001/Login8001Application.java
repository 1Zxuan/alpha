package com.bittereggs.login_8001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 楼中煊
 * @data 2019/3/24
 * @time 19:58
 */

@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class Login8001Application {

    public static void main(String[] args){
        SpringApplication.run(Login8001Application.class,args);
    }
}
