package com.tazine.aop.security;

import com.tazine.aop.service.AuthService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * SecurityAspect
 *
 * @author frank
 * @since 1.0.0
 */
@Aspect
@Component
public class SecurityAspect {

    @Autowired
    private AuthService authService;

    @Pointcut(value = "execution(public * com.tazine.aop.service.ProductService.*(..))")
    public void security(){}

    @Before(value = "security()")
    public void adminCheck(){
        authService.checkAccess();
    }


}
