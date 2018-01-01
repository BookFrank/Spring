package com.tazine.seckill.service;

import com.tazine.seckill.entity.Seckill;
import com.tazine.seckill.entity.dto.Exposer;
import com.tazine.seckill.entity.dto.SeckillExecution;
import com.tazine.seckill.exception.RepeatKillException;
import com.tazine.seckill.exception.SeckillCloseException;

import java.util.List;

/**
 * 秒杀 Web 接口
 *
 * @author frank
 * @since 1.0.0
 */
public interface SeckillService {

    /**
     * 查询所有秒杀记录
     *
     * @return
     */
    List<Seckill> getSeckillList();

    Seckill getById(long seckillId);

    /**
     * 秒杀开启时，输出秒杀接口地址，否则输出系统时间和秒杀时间
     *
     * @param seckillId
     * @return
     */
    Exposer exposeSeckillUrl(long seckillId);

    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
            throws SecurityException,SeckillCloseException,RepeatKillException;


}
