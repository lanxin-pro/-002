-- 创建订单表
CREATE TABLE IF NOT EXISTS t_order (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    park_id BIGINT NOT NULL COMMENT '停车场ID',
    user_id BIGINT NOT NULL COMMENT '用户ID',
    destination VARCHAR(255) NOT NULL COMMENT '目的地',
    duration INT NOT NULL COMMENT '预计骑行时长(小时)',
    total_cost DECIMAL(10,2) NOT NULL COMMENT '总费用',
    status INT NOT NULL COMMENT '订单状态：1待支付 2已支付 3已完成 4已取消',
    create_time DATETIME NOT NULL COMMENT '创建时间',
    update_time DATETIME NOT NULL COMMENT '更新时间',
    FOREIGN KEY (park_id) REFERENCES t_park(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单表';

-- 修改停车场表，添加可用车辆数量字段
ALTER TABLE t_park
ADD COLUMN available_bikes INT NOT NULL DEFAULT 0 COMMENT '可用车辆数量'; 