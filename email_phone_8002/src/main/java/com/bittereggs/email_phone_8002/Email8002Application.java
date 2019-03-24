package com.bittereggs.email_phone_8002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class Email8002Application {

    public static void main(String[] args) {
        SpringApplication.run(Email8002Application.class, args);
    }

}
