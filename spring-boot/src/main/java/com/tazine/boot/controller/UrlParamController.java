package com.tazine.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lina on 2018/1/8.
 *
 * @author frank
 * @since 1.0.0
 */
@RestController
public class UrlParamController {


    @GetMapping(value = "/path/{id}")
    public String pathVar(@PathVariable("id") String id){
        return id;
    }


    @GetMapping(value = "/req")
    public String reqParam(@RequestParam(value = "id", required = false, defaultValue = "请输入id") String id){
        return id;
    }

    @GetMapping("/http")
    public String servletParam(HttpServletRequest req, HttpServletResponse response){
        return req.getParameter("name");
    }


}
