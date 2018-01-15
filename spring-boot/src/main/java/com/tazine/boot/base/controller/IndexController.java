package com.tazine.boot.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * IndexController
 *
 * @author frank
 * @since 1.0.0
 */
@Controller
public class IndexController {

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

    @GetMapping(value = {"/index","/hi"})
    public String index() {
        return "index";
    }


}
