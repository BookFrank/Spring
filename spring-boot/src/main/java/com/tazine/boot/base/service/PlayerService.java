package com.tazine.boot.base.service;

import com.tazine.boot.base.entity.Player;
import com.tazine.boot.base.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lina on 2018/1/8.
 *
 * @author frank
 * @since 1.0.0
 */
@Service
public class PlayerService {


    @Autowired
    private PlayerRepository playerRepository;


    /**
     * 通过设置num=null异常，来测试事务
     */
    @Transactional
    public void insertTwo(){
        Player p1 = new Player();
        p1.setName("harden");
        p1.setNumber(3);
        p1.setTeam("rockets");
        playerRepository.save(p1);

        Player p2 = new Player();
        p2.setName("paul");
        //p2.setNumber(3);
        p2.setTeam("rockets");
        playerRepository.save(p2);
    }

    public Player findOne(Integer id){
        return playerRepository.findOne(id);
    }



}
