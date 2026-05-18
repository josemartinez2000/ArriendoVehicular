package com.Automotriz.soporteMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SoporteMsApplication {
    public static void main(String[] args) {
        SpringApplication.run(SoporteMsApplication.class, args);
    }
}
