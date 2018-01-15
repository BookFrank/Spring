package com.tazine.boot.aop.controller;

import com.tazine.boot.aop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lina on 2018/1/14.
 *
 * @author frank
 * @since 1.0.0
 */
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    public String insertProduct(){
        return "";
    }


}
