package com.tazine.boot.exception;

import com.tazine.boot.enums.ResultEnum;

/**
 * PlayerException
 * Spring 框架只会对运行时异常进行事务回滚
 *
 * @author frank
 * @since 1.0.0
 */
public class PlayerException extends RuntimeException {


    private Integer code;

    public PlayerException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public PlayerException(ResultEnum re) {
        super(re.getMsg());
        this.code = re.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
