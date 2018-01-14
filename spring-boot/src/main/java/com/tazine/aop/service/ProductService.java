package com.tazine.aop.service;

import com.tazine.aop.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lina on 2018/1/14.
 *
 * @author frank
 * @since 1.0.0
 */
@Service
public class ProductService {

    @Autowired
    private AuthService authService;

    public void insert(Product product) {
        // 传统方式，侵入式代码设计，需要在每个方法前都校验权限
        authService.checkAccess();
        System.out.println("Insert Product.");
    }

    public void delete(Long id) {
        authService.checkAccess();
        System.out.println("Delete Product.");
    }
}
