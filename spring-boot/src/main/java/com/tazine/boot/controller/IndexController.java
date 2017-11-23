package com.tazine.boot.controller;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.tazine.boot.listener.ConfigDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;
import java.util.Properties;

/**
 * Created by lina on 2017/11/23.
 */
@RestController
public class IndexController {

    @Autowired
    private ConfigDemo configDemo;

    @GetMapping(value = "/index")
    public String index(){
        String host = null;
        try {
            host = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return host + configDemo.getServerPort();
    }


}
