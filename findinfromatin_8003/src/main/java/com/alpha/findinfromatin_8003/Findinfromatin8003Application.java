package com.alpha.findinfromatin_8003;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Findinfromatin8003Application {

    public static void main(String[] args) {
        SpringApplication.run(Findinfromatin8003Application.class, args);
    }

}
