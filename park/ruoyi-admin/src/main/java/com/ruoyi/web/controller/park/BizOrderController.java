package com.ruoyi.web.controller.park;

import com.ruoyi.bigtian.domain.PayOrder;
import com.ruoyi.bigtian.service.PayOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.BizOrder;
import com.ruoyi.system.service.IBizOrderService;

@RestController
@RequestMapping("/park/order")
public class BizOrderController extends BaseController {
    @Autowired
    private IBizOrderService orderService;


    /**
     * 创建订单
     */
    @PostMapping("/create")
    public AjaxResult createOrder(@RequestBody BizOrder order) {
        try {
            // 检查是否还有可用车辆
            if (!orderService.checkAvailableBikes(order.getParkId())) {
                return AjaxResult.error("该停车场暂无可用车辆");
            }
            
            // 创建订单
            BizOrder createdOrder = orderService.createOrder(order);
            return AjaxResult.success(createdOrder);


        } catch (Exception e) {
            return AjaxResult.error("创建订单失败：" + e.getMessage());
        }
    }
} 