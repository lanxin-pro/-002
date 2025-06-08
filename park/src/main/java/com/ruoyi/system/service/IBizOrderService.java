package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.BizOrder;

/**
 * 订单Service接口
 * 
 * @author ruoyi
 */
public interface IBizOrderService {
    /**
     * 查询订单
     * 
     * @param id 订单主键
     * @return 订单
     */
    public BizOrder selectBizOrderById(Long id);

    /**
     * 查询订单列表
     * 
     * @param bizOrder 订单
     * @return 订单集合
     */
    public List<BizOrder> selectBizOrderList(BizOrder bizOrder);

    /**
     * 创建订单
     * 
     * @param bizOrder 订单
     * @return 结果
     */
    public int insertBizOrder(BizOrder bizOrder);

    /**
     * 修改订单
     * 
     * @param bizOrder 订单
     * @return 结果
     */
    public int updateBizOrder(BizOrder bizOrder);

    /**
     * 批量删除订单
     * 
     * @param ids 需要删除的订单主键集合
     * @return 结果
     */
    public int deleteBizOrderByIds(Long[] ids);

    /**
     * 删除订单信息
     * 
     * @param id 订单主键
     * @return 结果
     */
    public int deleteBizOrderById(Long id);

    /**
     * 支付订单
     * 
     * @param orderId 订单ID
     * @return 结果
     */
    public int payOrder(Long orderId);

    /**
     * 取消订单
     * 
     * @param orderId 订单ID
     * @return 结果
     */
    public int cancelOrder(Long orderId);

    /**
     * 完成订单
     * 
     * @param orderId 订单ID
     * @return 结果
     */
    public int completeOrder(Long orderId);
} 