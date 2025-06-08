DROP TABLE IF EXISTS `t_pay_order`;
CREATE TABLE `t_pay_order`  (
  `id` bigint NOT NULL,
  `user_id` bigint NULL DEFAULT NULL COMMENT '支付用户',
  `create_time` datetime NULL DEFAULT NULL COMMENT '支付时间',
  `park_id` bigint NULL DEFAULT NULL COMMENT '停车场id',
  `status` int NULL DEFAULT NULL COMMENT '状态（0：未支付；1：已支付）',
  `start_point` varchar(255) NULL DEFAULT NULL COMMENT '起点位置',
  `end_point` varchar(255) NULL DEFAULT NULL COMMENT '终点位置',
  `estimated_cost` decimal(10, 2) NULL DEFAULT NULL COMMENT '预计费用',
  `duration` int NULL DEFAULT NULL COMMENT '预计骑行时长(小时)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '支付订单' ROW_FORMAT = DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1; 