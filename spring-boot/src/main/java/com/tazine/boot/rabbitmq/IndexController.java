package com.tazine.boot.rabbitmq;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * IndexController
 *
 * @author frank
 * @since 1.0.0
 */
@RestController
public class IndexController {

    @GetMapping("/hi")
    public String hello(){
        return "Hello World";
    }

}
