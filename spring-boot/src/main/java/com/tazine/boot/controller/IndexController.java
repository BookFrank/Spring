package com.tazine.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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

    @Autowired
    private Environment env;

//    @Autowired
//    private ConfigDemo configDemo;
//
//    @GetMapping(value = "/index")
//    public String index(){
//        String host = null;
//        try {
//            host = InetAddress.getLocalHost().getHostAddress();
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        }
//        return host + configDemo.getServerPort();
//    }

    @GetMapping(value = "/test")
    public String test() {
        return env.getProperty("username");
    }


}
