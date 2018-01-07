package com.tazine.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 配置文件读取
 *
 * @author frank
 * @since 1.0.0
 */
@RestController
public class ConfigController {

    @Value("${my.website}")
    private String website;

    @Value(("${my.est}"))
    private int est;

    @Autowired
    private Environment env;

    @RequestMapping(value = "/cfg", method = RequestMethod.GET)
    public String cfg() {
        return "使用@Value(\"${username}\")注解获取配置文件中配置 " + website + " est " + est;
    }

    @RequestMapping(value = "/envi", method = RequestMethod.GET)
    public String env() {
        System.out.println("env");
        return "使用@Autowired Environment env.getProperty(\"website\")获取配置 " + env.getProperty("my.website") + " <br/>" + env.getProperty("my.desc");
    }

}
