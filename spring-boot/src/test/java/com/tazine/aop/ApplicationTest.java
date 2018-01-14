package com.tazine.aop;

import com.tazine.aop.security.CurrentUserHolder;
import com.tazine.aop.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * Aop Package Tests
 *
 * @author frank
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    private ProductService productService;

    @Test(expected = RuntimeException.class)
    public void annoSignIn(){
        CurrentUserHolder.set("frank");
        productService.delete(1L);
    }

    @Test
    public void adminSignIn(){
        CurrentUserHolder.set("admin");
        productService.delete(1L);
    }


}