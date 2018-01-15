package com.tazine.boot.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by lina on 2018/1/15.
 *
 * @author frank
 * @since 1.0.0
 */
public class Runner implements CommandLineRunner {


    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;
    private final ConfigurableApplicationContext context;

    public Runner(RabbitTemplate rabbitTemplate, Receiver receiver, ConfigurableApplicationContext context) {
        this.rabbitTemplate = rabbitTemplate;
        this.receiver = receiver;
        this.context = context;
    }

    @Override
    public void run(String... strings) throws Exception {

    }
}
