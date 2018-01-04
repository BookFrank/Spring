package com.tazine.boot.crontab;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Crontab：定时任务
 * @author frank
 * @since 1.0.0
 */
@Component
public class CrontabJobs {


    @Scheduled(cron = "0/5 * * * * *")
    public void hello(){
        System.out.println("Hello World");
    }



}
