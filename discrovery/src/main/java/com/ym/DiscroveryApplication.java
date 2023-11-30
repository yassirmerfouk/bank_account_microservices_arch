package com.ym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscroveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscroveryApplication.class, args);
    }

}
