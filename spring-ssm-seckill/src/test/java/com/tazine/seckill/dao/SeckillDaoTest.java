package com.tazine.seckill.dao;

import com.tazine.seckill.entity.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * SeckillDaoTest
 * 配置 spring 和 junit整合，启动 junit 的时候加载IOC容器
 *
 * @author frank
 * @since 1.0.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:spring/spring-dao.xml")
public class SeckillDaoTest {

    // 注入 DAO 实现依赖
    @Resource
    private SeckillDao seckillDao;

    @Test
    public void reduceStock() throws Exception {
        long id = 1000;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);
    }

    @Test
    public void queryById() throws Exception {
    }

    @Test
    public void queryAll() throws Exception {
    }

}