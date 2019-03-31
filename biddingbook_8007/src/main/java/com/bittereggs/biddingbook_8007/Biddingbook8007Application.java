package com.bittereggs.biddingbook_8007;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class Biddingbook8007Application {

    public static void main(String[] args) {
        SpringApplication.run(Biddingbook8007Application.class, args);
    }

}
