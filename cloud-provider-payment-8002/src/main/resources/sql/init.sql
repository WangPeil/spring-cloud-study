CREATE TABLE `payment`
(
    `id`     BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `serial` VARCHAR(200) DEFAULT '' COMMENT '序列号',
    `create_time` TIMESTAMP DEFAULT NOW() COMMENT '创建时间',
    `update_time` TIMESTAMP DEFAULT  NOW() ON UPDATE NOW() COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8 COMMENT '支付表';