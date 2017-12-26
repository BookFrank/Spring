-- 数据库初始化脚本

-- 创建数据库
CREATE DATABASE seckill;
-- 使用数据库
USE seckill;

-- 创建秒杀库存表
CREATE TABLE seckill (
  `seckill_id`  BIGINT       NOT NULL AUTO_INCREMENT
  COMMENT '商品库存ID',
  `name`        VARCHAR(120) NOT NULL
  COMMENT '商品名称',
  `number`      INT          NOT NULL
  COMMENT '商品库存数',
  `start_time`  TIMESTAMP    NOT NULL
  COMMENT '秒杀开始时间',
  `end_time`    TIMESTAMP    NOT NULL
  COMMENT '秒杀结束时间',
  `create_time` TIMESTAMP    NOT NULL DEFAULT current_timestamp
  COMMENT '创建时间',
  PRIMARY KEY (seckill_id),
  KEY idx_start_time(start_time),
  KEY idx_end_time(end_time),
  KEY idx_create_time(create_time)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = utf8
  COMMENT = '秒杀库存表';

-- 初始化数据
INSERT INTO seckill (NAME, NUMBER, start_time, end_time
)
VALUES
  ('3000元秒杀iPhone8', 100, '2017-12-26 10:00:00', '2017-12-26 15:00:00'
  ),
  ('2000元秒杀Note8', 200, '2017-12-26 10:00:00', '2017-12-26 15:00:00'
  ),
  ('1000元秒杀mate10', 300, '2017-12-26 10:00:00', '2017-12-26 15:00:00'
  ),
  ('8000元秒杀mi6', 400, '2017-12-26 10:00:00', '2017-12-26 15:00:00'
  );

-- 秒杀成功订单表
-- 用户登录认证相关的信息
CREATE TABLE seckill_orders (
  `seckill_id`  BIGINT    NOT NULL
  COMMENT '秒杀商品ID',
  `user_phone`  BIGINT    NOT NULL
  COMMENT '用户手机号',
  `state`       TINYINT   NOT NULL DEFAULT -1
  COMMENT '订单状态：-1-无效 0-成功 1-已付款 2-已发货',
  `create_time` TIMESTAMP NOT NULL
  COMMENT '创建时间',
  PRIMARY KEY (seckill_id, user_phone),
  KEY idx_create_time(create_time)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT = '秒杀成功订单表';
