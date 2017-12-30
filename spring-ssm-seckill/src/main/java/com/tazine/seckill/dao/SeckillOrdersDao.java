package com.tazine.seckill.dao;

import com.tazine.seckill.entity.SeckillOrders;

/**
 * 秒杀订单 SeckillOrdersDao Interface
 *
 * @author frank
 * @since 1.0.0
 */
public interface SeckillOrdersDao {

    /**
     * 插入购买明细（可过滤重复）
     *
     * @param secKillId
     * @param userPhone
     * @return 如果影响行数>1，表示更新行数
     */
    int insertSeckill(long secKillId, long userPhone);


    /**
     * 根据id查询秒杀订单并携带秒杀实体
     *
     * @param seckillId
     * @return
     */
    SeckillOrders queryByIdWithSeckill(long seckillId);


}
