package com.bittereggs.upload_8005;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class Upload8005Application {

    public static void main(String[] args) {
        SpringApplication.run(Upload8005Application.class, args);
    }

}
