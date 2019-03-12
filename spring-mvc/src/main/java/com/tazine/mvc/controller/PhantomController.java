package com.tazine.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author frank
 * @date 2018/02/28
 */
@Controller
public class PhantomController {

    @RequestMapping("/chart")
    public String eChart() {
        return "chart";
    }

}
