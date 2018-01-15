package com.tazine.boot.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * RabbitMQ Application
 *
 * @author frank
 * @since 1.0.0
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.tazine.boot.rabbitmq")
public class AmqpApp {
    public static void main(String[] args) {
        SpringApplication.run(AmqpApp.class, args);
    }
}
