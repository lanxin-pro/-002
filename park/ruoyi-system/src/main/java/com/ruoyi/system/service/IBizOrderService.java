package com.ruoyi.system.service;

import com.ruoyi.system.domain.BizOrder;
import java.util.List;

public interface IBizOrderService {
    /**
     * 创建订单
     */
    public BizOrder createOrder(BizOrder order);

    /**
     * 检查停车场是否有可用车辆
     */
    public boolean checkAvailableBikes(Long parkId);

    /**
     * 查询订单列表
     */
    public List<BizOrder> selectOrderList();

    /**
     * 根据用户ID查询订单
     */
    public List<BizOrder> selectOrdersByUserId(Long userId);

    /**
     * 根据订单ID查询订单
     */
    public BizOrder selectOrderById(Long orderId);

    /**
     * 更新订单状态
     */
    public int updateOrderStatus(Long orderId, Integer status);
} 