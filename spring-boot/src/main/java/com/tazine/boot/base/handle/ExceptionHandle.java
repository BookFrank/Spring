package com.tazine.boot.base.handle;

import com.tazine.boot.base.entity.HttpResult;
import com.tazine.boot.base.exception.PlayerException;
import com.tazine.boot.base.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Exception Advice
 *
 * @author frank
 * @since 1.0.0
 */
@ControllerAdvice
public class ExceptionHandle {

    private static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public HttpResult handle(Exception e) {
        if (e instanceof PlayerException) {
            PlayerException playerException = (PlayerException) e;
            return ResultUtil.error(playerException.getCode(), playerException.getMessage());
        }
        logger.error(e.getMessage());
        return ResultUtil.error(100, e.getMessage());
    }
}

