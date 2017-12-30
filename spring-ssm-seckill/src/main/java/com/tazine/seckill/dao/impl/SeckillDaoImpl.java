package com.tazine.seckill.dao.impl;

import com.tazine.seckill.dao.SeckillDao;
import com.tazine.seckill.entity.Seckill;

import java.util.Date;
import java.util.List;

/**
 * 秒杀 SeckillDaoImpl
 *
 * @author frank
 * @since 1.0.0
 */
public class SeckillDaoImpl implements SeckillDao {
    @Override
    public int reduceStock(long seckillId, Date killDate) {
        return 0;
    }

    @Override
    public Seckill queryById(long secKillId) {
        return null;
    }

    @Override
    public List<Seckill> queryAll(int offset, int limit) {
        return null;
    }
}
