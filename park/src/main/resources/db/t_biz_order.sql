-- ----------------------------
-- Table structure for t_biz_order
-- ----------------------------
DROP TABLE IF EXISTS `t_biz_order`;
CREATE TABLE `t_biz_order` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `order_no` varchar(32) NOT NULL COMMENT '订单编号',
  `user_id` bigint NOT NULL COMMENT '用户ID',
  `park_id` bigint NOT NULL COMMENT '停车场ID',
  `bike_id` bigint NOT NULL COMMENT '单车ID',
  `amount` decimal(10,2) NOT NULL COMMENT '订单金额',
  `status` char(1) NOT NULL COMMENT '订单状态（0待支付 1已支付 2已完成 3已取消）',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `pay_time` datetime DEFAULT NULL COMMENT '支付时间',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_order_no` (`order_no`),
  KEY `idx_user_id` (`user_id`),
  KEY `idx_park_id` (`park_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='订单表';

-- ----------------------------
-- 修改停车场表，添加可用单车数量字段
-- ----------------------------
ALTER TABLE `t_parks` 
ADD COLUMN `available_bikes` int DEFAULT '0' COMMENT '可用单车数量' AFTER `residue_vehicle_num`; 