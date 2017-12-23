package com.tazine.basic.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Logback 异步输出线程实践
 *
 * @author Frank
 * @since 1,0,0
 */
public class LogbackDemo {

    private static final Logger logger = LoggerFactory.getLogger(LogbackDemo.class);

    public static void main(String[] args) {

        // JPS 查看当前程序进程号
        // jstack -l number 查看线程运行状态
        while (true) {
            logger.info("Logback 异步打印 info 日志");
            logger.debug("Logback 异步打印 debug 日志");
            logger.warn("Logback 异步打印 warn 日志");

            // LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
            // StatusPrinter.print(lc);

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
