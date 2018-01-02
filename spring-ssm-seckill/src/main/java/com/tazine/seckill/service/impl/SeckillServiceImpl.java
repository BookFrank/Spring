package com.tazine.seckill.service.impl;

import com.tazine.seckill.dao.SeckillDao;
import com.tazine.seckill.dao.SeckillOrdersDao;
import com.tazine.seckill.dto.Exposer;
import com.tazine.seckill.dto.SeckillExecution;
import com.tazine.seckill.entity.Seckill;
import com.tazine.seckill.entity.SeckillOrders;
import com.tazine.seckill.enums.SeckillStateEnum;
import com.tazine.seckill.exception.RepeatKillException;
import com.tazine.seckill.exception.SeckillCloseException;
import com.tazine.seckill.exception.SeckillException;
import com.tazine.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;

/**
 * SeckillServiceImpl
 *
 * @author frank
 * @since 1.0.0
 */
public class SeckillServiceImpl implements SeckillService {

    private static final Logger logger = LoggerFactory.getLogger("");

    // md5盐值字符串，加密MD5
    private final String ENCODE_SALT = "CPTBTPTP";

    @Autowired
    private SeckillDao seckillDao;

    @Autowired
    private SeckillOrdersDao seckillOrdersDao;

    @Override
    public List<Seckill> getSeckillList() {
        return seckillDao.queryAll(0, 4);
    }

    @Override
    public Seckill getById(long seckillId) {
        return seckillDao.queryById(seckillId);
    }

    @Override
    public Exposer exposeSeckillUrl(long seckillId) {
        Seckill seckill = getById(seckillId);
        if (null == seckill) {
            return new Exposer(false, seckillId);
        }
        Date startTime = seckill.getStartTime();
        Date endTime = seckill.getEndTime();
        Date nowTime = new Date();
        if (nowTime.getTime() < startTime.getTime() || nowTime.getTime() > endTime.getTime()) {
            return new Exposer(false, seckill.getSeckillId(), nowTime.getTime(), startTime.getTime(), endTime.getTime());
        }
        // 转化特定字符串的过程，不可逆
        String md5 = getMD5(seckillId);
        return new Exposer(true, md5, seckillId);
    }

    @Override
    public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5) throws SeckillException, SeckillCloseException, RepeatKillException {
        try {
            if (null == md5 || !md5.equalsIgnoreCase(getMD5(seckillId))) {
                throw new SeckillException("wrong data rewrite");
            }
            // 执行秒杀逻辑：减库存 + 生成订单
            int updateRet = seckillDao.reduceStock(seckillId, new Date());
            if (updateRet <= 0) {
                throw new SeckillCloseException("this seckill is closed");
            } else {
                int insertRet = seckillOrdersDao.insertSeckill(seckillId, userPhone);
                if (insertRet <= 0) {
                    throw new RepeatKillException("seckill repeated");
                } else {
                    SeckillOrders order = seckillOrdersDao.queryByIdWithSeckill(seckillId);
                    return new SeckillExecution(seckillId, SeckillStateEnum.SUCCESS, order);
                }
            }
        } catch (SeckillCloseException | RepeatKillException e1) {
            throw e1;
        } catch (Exception e) {
            logger.error(e.getMessage());
            // 抛出业务异常，所有编译期异常转化为运行期异常，因为继承自RuntimeException，Spring声明式事务可以在发生异常时完成Rollback
            throw new SeckillException("seckill inner error" + e.getMessage());
        }
    }

    private String getMD5(long seckillId) {
        String base = seckillId + "/" + ENCODE_SALT;
        return DigestUtils.md5DigestAsHex(base.getBytes());
    }
}
