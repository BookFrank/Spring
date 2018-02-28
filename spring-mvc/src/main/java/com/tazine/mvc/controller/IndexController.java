package com.tazine.mvc.controller;

import com.tazine.mvc.pojo.Player;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


/**
 * IndexController
 * 实现 EnvironmentAware 接口获得对 Environment 的感知能力
 *
 * @author jiaer.ly
 * @date 2018/02/17
 */
@Controller
public class IndexController implements EnvironmentAware {

    private Environment environment;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("str", "hello world");
        return "index";
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @RequestMapping("/date")
    @ResponseBody
    public String date(Player player) {
        return player.toString();
    }


    @RequestMapping(value = "/players", method = RequestMethod.POST)
    @ResponseBody
    public List<Player> getList(String name, String region) {
        System.out.println(name);
        System.out.println(region);
        List<Player> players = new ArrayList<>();
//        for (int i=0;i<3;i++){
//            Player p = new Player("kobe"+i,new Date());
//            players.add(p);
//        }
        return players;
    }

}
