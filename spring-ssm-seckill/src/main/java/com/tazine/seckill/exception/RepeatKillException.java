package com.tazine.seckill.exception;

/**
 * 重复秒杀异常（运行期异常）
 *
 * @author frank
 * @since 1.0.0
 */
public class RepeatKillException extends SeckillException{


    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
