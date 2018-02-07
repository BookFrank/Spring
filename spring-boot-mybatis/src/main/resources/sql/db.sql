-- 数据库初始化脚本

-- 创建数据库
CREATE DATABASE mybatis;
-- 使用数据库
USE mybatis;

-- 创建区域表
CREATE TABLE tb_area (
  `area_id`          INT(2)       NOT NULL AUTO_INCREMENT
  COMMENT '区域ID',
  `area_name`        VARCHAR(120) NOT NULL
  COMMENT '区域名称',
  `priority`         INT(2)       NOT NULL DEFAULT 0
  COMMENT '优先级',
  `create_time`      DATETIME     NOT NULL DEFAULT DATE
  COMMENT '创建时间',
  `last_modify_time` DATETIME     NOT NULL DEFAULT DATE
  COMMENT '最后修改时间',
  PRIMARY KEY (area_id),
  UNIQUE KEY `UK_AREA` (`area_name`),
  KEY idx_area_id(area_id),
  KEY idx_create_time(create_time)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8
  COMMENT = '区域表';

-- 初始化数据
INSERT INTO tb_area (area_name, priority
)
VALUES
  ('通州', 2
  ),
  ('朝阳', 1
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
