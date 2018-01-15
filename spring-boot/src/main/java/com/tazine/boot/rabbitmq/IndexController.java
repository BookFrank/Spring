package com.tazine.boot.rabbitmq;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lina on 2018/1/15.
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
