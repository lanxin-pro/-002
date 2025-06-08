package com.southwind.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.southwind.common.PayOrder;
import java.util.List;

public interface OrderService extends IService<PayOrder> {
    
    /**
     * 获取订单列表
     */
    List<PayOrder> getOrderList();

    /**
     * 根据用户ID获取订单
     */
    List<PayOrder> getOrdersByUserId(Long userId);

    /**
     * 根据订单ID获取订单
     */
    PayOrder getOrderById(Long orderId);

    /**
     * 更新订单状态
     */
    // boolean updateOrderStatus(Long orderId, Integer status);
}