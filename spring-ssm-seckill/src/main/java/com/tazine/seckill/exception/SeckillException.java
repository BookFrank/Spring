package com.tazine.seckill.exception;

/**
 * 秒杀异常
 *
 * @author frank
 * @since 1.0.0
 */
public class SeckillException extends RuntimeException {

    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
