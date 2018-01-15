package com.tazine.boot.base.utils;

import com.tazine.boot.base.entity.HttpResult;

/**
 * 返回结果工具类
 *
 * @author frank
 * @since 1.0.0
 */
public class ResultUtil {

    @SuppressWarnings("unchecked")
    public static HttpResult success(Object object){
        HttpResult result = new HttpResult();
        result.setCode(0);
        result.setMsg("success");
        result.setData(object);
        return result;
    }

    public static HttpResult success(){
        return success(null);
    }

    public static HttpResult error(int code, String msg){
        HttpResult result = new HttpResult();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

}
