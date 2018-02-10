package com.tazine.bootwar.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lina on 2018/2/10.
 *
 * @author frank
 * @since 1.0.0
 */
@RestController
public class IndexController {

    @RequestMapping(value = "/hello")
    public String hello(){
        return "Hello World";
    }
}
