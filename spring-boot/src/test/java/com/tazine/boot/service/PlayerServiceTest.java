package com.tazine.boot.service;

import com.tazine.boot.entity.Player;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by lina on 2018/1/9.
 *
 * @author frank
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PlayerServiceTest {

    @Autowired
    private PlayerService playerService;

    @Test
    public void findOne() throws Exception {
        Player p = playerService.findOne(1);
        Assert.assertEquals(new Integer(1), p.getId());
    }

}