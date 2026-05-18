package com.Automotriz.tarifasMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients  // ← ¿tienes esta línea?
public class TarifasMsApplication {
    public static void main(String[] args) {
        SpringApplication.run(TarifasMsApplication.class, args);
    }
}