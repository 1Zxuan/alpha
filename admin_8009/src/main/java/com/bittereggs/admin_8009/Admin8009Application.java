package com.bittereggs.admin_8009;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class Admin8009Application {

    public static void main(String[] args) {
        SpringApplication.run(Admin8009Application.class, args);
    }

}
