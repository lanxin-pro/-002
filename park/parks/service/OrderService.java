package parks.service;

import parks.entity.Order;

public interface OrderService {
    boolean checkAvailableBikes(Long parkId);
    Order createOrder(Order order);
} 