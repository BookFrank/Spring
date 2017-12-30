package com.tazine.seckill.dao;

import com.tazine.seckill.entity.Seckill;

import java.util.Date;
import java.util.List;

/**
 * Created by lina on 2017/12/25.
 *
 * @author frank
 * @since 1.0.0
 */
public interface SeckillDao {


    /**
     * 减库存
     * @param seckillId
     * @param killDate
     * @return 如果影响行数>1，表示更新行数
     */
    int reduceStock(long seckillId, Date killDate);

    /**
     *
     * @param secKillId
     * @return
     */
    Seckill queryById(long secKillId);

    /**
     *
     * @param offset
     * @param limit
     * @return
     */
    List<Seckill> queryAll(int offset, int limit);

}
