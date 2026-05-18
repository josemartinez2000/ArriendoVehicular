package com.Automotriz.fidelizacionMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FidelizacionMsApplication {
    public static void main(String[] args) {
        SpringApplication.run(FidelizacionMsApplication.class, args);
    }
}
