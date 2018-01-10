package com.tazine.boot.enums;

/**
 * 返回结果枚举
 *
 * @author frank
 * @since 1.0.0
 */
public enum ResultEnum {


    UNKNOWN_ERROR(-1,"未知错误");

    private int code;
    private String msg;

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
