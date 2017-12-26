package com.tazine.seckill.entity;

import java.util.Date;

/**
 * Created by lina on 2017/12/25.
 *
 * @author frank
 * @since 1.0.0
 */
public class SeckillOrders {

    private long seckillId;

    private long userPhone;

    private short state;

    private Date createTime;

    // 多对一复合属性，在多方把一方保存
    private Seckill seckill;

    @Override
    public String toString() {
        return "SeckillOrders{" +
                "seckillId=" + seckillId +
                ", userPhone=" + userPhone +
                ", state=" + state +
                ", createTime=" + createTime +
                ", seckill=" + seckill +
                '}';
    }

    public Seckill getSeckill() {
        return seckill;
    }

    public void setSeckill(Seckill seckill) {
        this.seckill = seckill;
    }

    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(long userPhone) {
        this.userPhone = userPhone;
    }

    public short getState() {
        return state;
    }

    public void setState(short state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
