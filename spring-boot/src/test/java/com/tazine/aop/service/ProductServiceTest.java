package com.tazine.aop.service;

import com.tazine.aop.security.CurrentUserHolder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ProductServiceTest
 *
 * @author frank
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    public void classicalDelete() throws Exception {
        CurrentUserHolder.set("frank");
        productService.classicalDelete(1L);
    }

    @Test
    public void baseAopDelete() throws Exception {
        CurrentUserHolder.set("frank");
        productService.baseAopDelete(1L);
    }

}