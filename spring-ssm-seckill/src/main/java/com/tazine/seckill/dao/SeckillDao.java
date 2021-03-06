package com.tazine.seckill.dao;

import com.tazine.seckill.entity.Seckill;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 秒杀 DAO Interface
 *
 * @author frank
 * @since 1.0.0
 */
public interface SeckillDao {


    /**
     * 减库存
     *
     * @param seckillId
     * @param killDate
     * @return 如果影响行数>1，表示更新行数
     */
    int reduceStock(long seckillId, Date killDate);

    /**
     * @param secKillId
     * @return
     */
    Seckill queryById(long secKillId);

    /**
     * @param offset
     * @param limit
     * @return
     */
    List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);

}
