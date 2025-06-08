package parks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import parks.common.Result;
import parks.entity.Order;
import parks.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public Result createOrder(@RequestBody Order order) {
        try {
            // 检查是否还有可用车辆
            if (!orderService.checkAvailableBikes(order.getParkId())) {
                return Result.error("该停车场暂无可用车辆");
            }
            
            // 创建订单
            Order createdOrder = orderService.createOrder(order);
            return Result.success(createdOrder);
        } catch (Exception e) {
            return Result.error("创建订单失败：" + e.getMessage());
        }
    }
} 