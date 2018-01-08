package com.tazine.boot.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * HttpAspect
 *
 * @author frank
 * @since 1.0.0
 */
@Aspect
@Component
public class HttpAspect {

    private static final Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    /**
     * 拦截方法
     */
    @Before("execution(public * com.tazine.boot.controller.PlayerController.list(..))")
    public void alog() {
        System.out.println(11111);
    }

    @Before("execution(public * com.tazine.boot.controller.PlayerController.*(..))")
    public void globalLog() {
        System.out.println("收到请求");
    }


    @Pointcut("execution(public * com.tazine.boot.controller.PlayerController.*(..))")
    private void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("收到请求");

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        System.out.println(request.getRequestURI());

        //class
        System.out.println(joinPoint.getSignature().getDeclaringTypeName());
        System.out.println(joinPoint.getSignature().getName());

        // args
        System.out.println(joinPoint.getArgs().toString());
    }

    @After("log()")
    public void doAfter() {
        System.out.println("请求处理完成");
    }


    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturn(Object object) {
        System.out.println(object.toString());
    }


}
