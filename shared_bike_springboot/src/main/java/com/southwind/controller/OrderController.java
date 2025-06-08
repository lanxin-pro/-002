package com.southwind.controller;

import com.southwind.common.PayOrder;
import com.southwind.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 获取订单列表
     */
    @GetMapping("/list")
    public Map<String, Object> getOrderList() {
        Map<String, Object> result = new HashMap<>();
        try {
            List<PayOrder> orders = orderService.getOrderList();
            result.put("code", 200);
            result.put("msg", "获取订单列表成功");
            result.put("data", orders);
        } catch (Exception e) {
            result.put("code", 500);
            result.put("msg", "获取订单列表失败：" + e.getMessage());
        }
        return result;
    }

    /**
     * 根据用户ID获取订单
     */
    @GetMapping("/user/{userId}")
    public Map<String, Object> getUserOrders(@PathVariable("userId") Long userId) {
        Map<String, Object> result = new HashMap<>();
        try {
            List<PayOrder> orders = orderService.getOrdersByUserId(userId);
            result.put("code", 200);
            result.put("msg", "获取用户订单成功");
            result.put("data", orders);
        } catch (Exception e) {
            result.put("code", 500);
            result.put("msg", "获取用户订单失败：" + e.getMessage());
        }
        return result;
    }

    /**
     * 获取订单详情
     */
    @GetMapping("/{orderId}")
    public Map<String, Object> getOrderDetail(@PathVariable("orderId") Long orderId) {
        Map<String, Object> result = new HashMap<>();
        try {
            PayOrder order = orderService.getOrderById(orderId);
            result.put("code", 200);
            result.put("msg", "获取订单详情成功");
            result.put("data", order);
        } catch (Exception e) {
            result.put("code", 500);
            result.put("msg", "获取订单详情失败：" + e.getMessage());
        }
        return result;
    }

    /**
     * 更新订单状态
     */
//    @PutMapping("/{orderId}/status")
//    public Map<String, Object> updateOrderStatus(
//            @PathVariable("orderId") Long orderId,
//            @RequestParam("status") Integer status) {
//        Map<String, Object> result = new HashMap<>();
//        try {
//            boolean success = orderService.updateOrderStatus(orderId, status);
//            if (success) {
//                result.put("code", 200);
//                result.put("msg", "更新订单状态成功");
//            } else {
//                result.put("code", 500);
//                result.put("msg", "更新订单状态失败：订单不存在");
//            }
//        } catch (Exception e) {
//            result.put("code", 500);
//            result.put("msg", "更新订单状态失败：" + e.getMessage());
//        }
//        return result;
//    }
}