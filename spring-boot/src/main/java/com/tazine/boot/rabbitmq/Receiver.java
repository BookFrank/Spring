package com.tazine.boot.rabbitmq;

import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 * Created by lina on 2018/1/15.
 *
 * @author frank
 * @since 1.0.0
 */
@Component
public class Receiver {


    // 倒计数锁存器
    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message){
        System.out.println("Received < " + message + " >");
        latch.countDown();
    }

    public CountDownLatch getLatch(){
        return latch;
    }


}
