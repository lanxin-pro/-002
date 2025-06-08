package com.ruoyi.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.BizOrder;
import com.ruoyi.bigtian.domain.Parks;
import com.ruoyi.system.mapper.BizOrderMapper;
import com.ruoyi.bigtian.mapper.ParksMapper;
import com.ruoyi.system.service.IBizOrderService;

import java.util.List;

@Service
public class BizOrderServiceImpl implements IBizOrderService {
    @Autowired
    private BizOrderMapper orderMapper;

    @Autowired
    private ParksMapper parksMapper;

    @Override
    public boolean checkAvailableBikes(Long parkId) {
        Parks park = parksMapper.selectParksById(parkId);
        return park != null && park.getAvailableBikes() > 0;
    }

    @Override
    @Transactional
    public BizOrder createOrder(BizOrder order) {
        order.setCreateTime(DateUtils.getNowDate());
        order.setUpdateTime(DateUtils.getNowDate());
        order.setStatus(1); // 待支付状态

        // 保存订单
        orderMapper.insertOrder(order);

        // 更新停车场可用车辆数量
        parksMapper.decrementAvailableBikes(order.getParkId());

        return order;
    }

    @Override
    public List<BizOrder> selectOrderList() {
        return orderMapper.selectOrderList();
    }

    @Override
    public List<BizOrder> selectOrdersByUserId(Long userId) {
        return orderMapper.selectOrdersByUserId(userId);
    }

    @Override
    public BizOrder selectOrderById(Long orderId) {
        return orderMapper.selectOrderById(orderId);
    }

    @Override
    @Transactional
    public int updateOrderStatus(Long orderId, Integer status) {
        BizOrder order = new BizOrder();
        order.setId(orderId);
        order.setStatus(status);
        order.setUpdateTime(DateUtils.getNowDate());
        return orderMapper.updateOrder(order);
    }
} 