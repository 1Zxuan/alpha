package com.bittereggs.attention_8006;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class Attention8006Application {

    public static void main(String[] args) {
        SpringApplication.run(Attention8006Application.class, args);
    }

}
