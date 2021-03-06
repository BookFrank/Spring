package com.tazine.seckill.dto;

import com.tazine.seckill.entity.SeckillOrders;
import com.tazine.seckill.enums.SeckillStateEnum;

/**
 * 封装秒杀执行后结果
 *
 * @author frank
 * @since 1.0.0
 */
public class SeckillExecution {

    private long seckillId;

    private int state;

    private String stateInfo;

    private SeckillOrders seckillOrder;

    public SeckillExecution(long seckillId, SeckillStateEnum seckillStateEnum, SeckillOrders seckillOrder) {
        this.seckillId = seckillId;
        this.state = seckillStateEnum.getState();
        this.stateInfo = seckillStateEnum.getStateInfo();
        this.seckillOrder = seckillOrder;
    }

    public SeckillExecution(long seckillId, SeckillStateEnum seckillStateEnum) {
        this.seckillId = seckillId;
        this.state = seckillStateEnum.getState();
        this.stateInfo = seckillStateEnum.getStateInfo();
    }

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public SeckillOrders getSeckillOrder() {
        return seckillOrder;
    }

    public void setSeckillOrder(SeckillOrders seckillOrder) {
        this.seckillOrder = seckillOrder;
    }
}
