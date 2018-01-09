package com.tazine.boot.handle;

import com.tazine.boot.entity.HttpResult;
import com.tazine.boot.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lina on 2018/1/9.
 *
 * @author frank
 * @since 1.0.0
 */
@ControllerAdvice
public class ExceptionHandle {


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public HttpResult handle(Exception e){

        return ResultUtil.error(100, e.getMessage());

    }


}

