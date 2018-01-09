package com.tazine.boot.controller;

import com.tazine.boot.entity.Player;
import com.tazine.boot.repository.PlayerRepository;
import com.tazine.boot.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * PlayerController
 *
 * @author frank
 * @since 1.0.0
 */
@RestController
@RequestMapping(value = "/player")
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PlayerService playerService;

    @GetMapping(value = "/list")
    public List<Player> list() {
        return playerRepository.findAll();
    }

    @GetMapping(value = "/add")
    public Player add(@RequestParam("name") String name, @RequestParam("num") int num, @RequestParam("team") String team) {
        Player player = new Player();
        player.setName(name);
        player.setNumber(num);
        player.setTeam(team);
        return playerRepository.save(player);
    }

    /**
     * 使用对象作为参数
     *
     * @param player
     * @return
     */
    @GetMapping("/create")
    public Player create(@Valid Player player, BindingResult result) throws Exception {
        if (result.hasErrors()) {
            System.out.println(result.getFieldError().getDefaultMessage());
            throw new Exception("您输入的参数有误");
            //return null;
        }
        return playerRepository.save(player);
    }

    @GetMapping("/find")
    public Player find(@RequestParam("id") int id, @RequestParam(value = "name", required = false
    ) String name) {
        if (null != name) {
            return playerRepository.findByName(name).get(0);
        }
        return playerRepository.findOne(id);
    }

    @GetMapping("/insert")
    public void insert() {
        playerService.insertTwo();
    }
}
