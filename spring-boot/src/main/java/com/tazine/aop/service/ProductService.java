package com.tazine.aop.service;

import com.tazine.aop.domain.Product;
import com.tazine.aop.security.AdminOnly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ProductService
 *
 * @author frank
 * @since 1.0.0
 */
@Service
public class ProductService {

    @Autowired
    private AuthService authService;

    public void insert(Product product) {
        System.out.println("Insert Product.");
    }

    /**
     * 传统权限校验方式
     * 侵入式代码设计，需要在每个方法前都校验权限
     *
     * @param id
     */
    public void classicalDelete(Long id) {
        authService.checkAccess();
        System.out.println("Delete Product.");
    }

    /**
     * 基于传统 AOP 切面的权限校验
     *
     * @param id
     */
    public void baseAopDelete(Long id) {
        System.out.println("Delete Product.");
    }

    /**
     * 基于注解 AOP 切面的权限校验
     *
     * @param id
     */
    @AdminOnly
    public void annoAopDelete(Long id) {
        System.out.println("Delete Product.");
    }


}
