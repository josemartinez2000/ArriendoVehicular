package com.Automotriz.reservasMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ReservasMsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReservasMsApplication.class, args);
    }
}
