package com.tazine.boot.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScan(basePackages = "com.tazine.boot.aop")
@EnableScheduling
@EnableConfigurationProperties
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(com.tazine.boot.base.Application.class, args);
    }
}
