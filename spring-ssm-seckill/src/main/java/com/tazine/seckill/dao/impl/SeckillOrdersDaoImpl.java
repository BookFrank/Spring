package com.tazine.seckill.dao.impl;

import com.tazine.seckill.dao.SeckillOrdersDao;
import com.tazine.seckill.entity.SeckillOrders;

/**
 * 秒杀订单 SeckillOrdersDaoImpl
 *
 * @author frank
 * @since 1.0.0
 */
public class SeckillOrdersDaoImpl implements SeckillOrdersDao {
    @Override
    public int insertSeckill(long secKillId, long userPhone) {
        return 0;
    }

    @Override
    public SeckillOrders queryByIdWithSeckill(long seckillId) {
        return null;
    }
}
