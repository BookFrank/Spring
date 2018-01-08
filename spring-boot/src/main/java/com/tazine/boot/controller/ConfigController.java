package com.tazine.boot.controller;

import com.tazine.boot.dto.MailCfg;
import com.tazine.boot.dto.Website;
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

    @Value("${website.founder}")
    private String founder;

    @Value(("${website.est}"))
    private int est;

    @Autowired
    private Environment env;

    @Autowired
    private Website website;

    @Autowired
    private MailCfg mail;

    @RequestMapping(value = "/cfg", method = RequestMethod.GET)
    public String cfg() {
        return "使用@Value(\"${website.founder}\")注解获取配置文件中配置 " + founder + " est " + est;
    }

    @RequestMapping(value = "/envi", method = RequestMethod.GET)
    public String env() {
        return "使用@Autowired Environment env.getProperty(\"website.url\")获取配置 " + env.getProperty("website.url") + " <br/>" + env.getProperty("website.desc");
    }

    @RequestMapping(value = "/website", method = RequestMethod.GET)
    public Website website() {
        return website;
    }


    @RequestMapping(value = "/mail", method = RequestMethod.GET)
    public MailCfg mail(){
        return mail;
    }

}
