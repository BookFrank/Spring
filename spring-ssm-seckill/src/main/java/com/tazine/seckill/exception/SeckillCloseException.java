package com.tazine.seckill.exception;

/**
 * 秒杀关闭异常
 *
 * @author frank
 * @since 1.0.0
 */
public class SeckillCloseException extends SeckillException {

    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
