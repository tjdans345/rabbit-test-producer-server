package com.example.rabbittestserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RabbitTestServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitTestServerApplication.class, args);
    }

}
