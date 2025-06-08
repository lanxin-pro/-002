package parks.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import parks.entity.Order;
import parks.entity.Park;
import parks.mapper.OrderMapper;
import parks.mapper.ParkMapper;
import parks.service.OrderService;

import java.time.LocalDateTime;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ParkMapper parkMapper;

    @Override
    public boolean checkAvailableBikes(Long parkId) {
        Park park = parkMapper.selectById(parkId);
        return park != null && park.getAvailableBikes() > 0;
    }

    @Override
    @Transactional
    public Order createOrder(Order order) {
        // 设置订单基本信息
        order.setCreateTime(LocalDateTime.now());
        order.setUpdateTime(LocalDateTime.now());
        order.setStatus(1); // 待支付状态

        // 保存订单
        orderMapper.insert(order);

        // 更新停车场可用车辆数量
        parkMapper.decrementAvailableBikes(order.getParkId());

        return order;
    }
} 