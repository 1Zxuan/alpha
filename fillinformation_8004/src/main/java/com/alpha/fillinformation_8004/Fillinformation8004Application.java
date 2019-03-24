package com.alpha.fillinformation_8004;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class Fillinformation8004Application {

    public static void main(String[] args) {
        SpringApplication.run(Fillinformation8004Application.class, args);
    }

}
