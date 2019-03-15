package com.bittereggs.login_8001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class Login8001Application {

    public static void main(String[] args) {
        SpringApplication.run(Login8001Application.class, args);
    }

}
