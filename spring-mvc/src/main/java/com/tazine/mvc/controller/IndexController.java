package com.tazine.mvc.controller;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * IndexController
 *
 * @author jiaer.ly
 * @date 2018/02/17
 */
@Controller
public class IndexController implements EnvironmentAware{

    private Environment environment;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("str", "hello world");
        return "index.jsp";
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
