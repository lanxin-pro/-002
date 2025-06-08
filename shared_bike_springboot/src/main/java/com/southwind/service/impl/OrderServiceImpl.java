package com.southwind.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.southwind.common.PayOrder;
import com.southwind.mapper.OrderMapper;
import com.southwind.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, PayOrder> implements OrderService {

    @Override
    public List<PayOrder> getOrderList() {
        return list(new QueryWrapper<PayOrder>()
                .orderByDesc("create_time"));
    }

    @Override
    public List<PayOrder> getOrdersByUserId(Long userId) {
        return list(new QueryWrapper<PayOrder>()
                .eq("user_id", userId)
                .orderByDesc("create_time"));
    }

    @Override
    public PayOrder getOrderById(Long orderId) {
        return getById(orderId);
    }

//    @Override
//    @Transactional
//    public boolean updateOrderStatus(Long orderId, Integer status) {
//        PayOrder order = getById(orderId);
//        if (order == null) {
//            return false;
//        }
//
//        order.setStatus(status);
//        order.setUpdateTime(new Date());
//
//        // 如果是支付状态，设置支付时间
//        if (status == 1) {
//            order.setPayTime(new Date());
//        }
//        // 如果是完成或取消状态，设置结束时间
//        else if (status == 2 || status == 3) {
//            order.setEndTime(new Date());
//        }
//
//        return updateById(order);
//    }
}