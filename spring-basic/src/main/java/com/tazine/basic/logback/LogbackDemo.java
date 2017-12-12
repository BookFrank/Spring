package com.tazine.basic.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class LogbackDemo {

    private static final Logger logger = LoggerFactory.getLogger(LogbackDemo.class);

    public static void main(String[] args) {

        while (true){
            logger.info("Logback 异步打印 info 日志");
            logger.debug("Logback 异步打印 debug 日志");
            logger.warn("Logback 异步打印 warn 日志");

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
