package com.ruoyi.bike.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.bike.mapper.BizOrderMapper;
import com.ruoyi.bike.domain.BizOrder;
import com.ruoyi.bike.service.IBizOrderService;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;

/**
 * 订单Service业务层处理
 * 
 * @author ruoyi
 */
@Service
public class BizOrderServiceImpl implements IBizOrderService {
    @Autowired
    private BizOrderMapper bizOrderMapper;

    /**
     * 查询订单
     * 
     * @param id 订单主键
     * @return 订单
     */
    @Override
    public BizOrder selectBizOrderById(Long id) {
        return bizOrderMapper.selectBizOrderById(id);
    }

    /**
     * 查询订单列表
     * 
     * @param bizOrder 订单
     * @return 订单
     */
    @Override
    public List<BizOrder> selectBizOrderList(BizOrder bizOrder) {
        return bizOrderMapper.selectBizOrderList(bizOrder);
    }

    /**
     * 新增订单
     * 
     * @param bizOrder 订单
     * @return 结果
     */
    @Override
    @Transactional
    public int insertBizOrder(BizOrder bizOrder) {
        bizOrder.setCreateTime(DateUtils.getNowDate());
        bizOrder.setCreateBy(SecurityUtils.getUsername());
        bizOrder.setOrderNo(generateOrderNo());
        bizOrder.setStatus("0"); // 待支付
        bizOrder.setStartTime(new Date());
        return bizOrderMapper.insertBizOrder(bizOrder);
    }

    /**
     * 修改订单
     * 
     * @param bizOrder 订单
     * @return 结果
     */
    @Override
    public int updateBizOrder(BizOrder bizOrder) {
        bizOrder.setUpdateTime(DateUtils.getNowDate());
        bizOrder.setUpdateBy(SecurityUtils.getUsername());
        return bizOrderMapper.updateBizOrder(bizOrder);
    }

    /**
     * 批量删除订单
     * 
     * @param ids 需要删除的订单主键
     * @return 结果
     */
    @Override
    public int deleteBizOrderByIds(Long[] ids) {
        return bizOrderMapper.deleteBizOrderByIds(ids);
    }

    /**
     * 删除订单信息
     * 
     * @param id 订单主键
     * @return 结果
     */
    @Override
    public int deleteBizOrderById(Long id) {
        return bizOrderMapper.deleteBizOrderById(id);
    }

    /**
     * 支付订单
     * 
     * @param orderId 订单ID
     * @return 结果
     */
    @Override
    @Transactional
    public int payOrder(Long orderId) {
        BizOrder order = new BizOrder();
        order.setId(orderId);
        order.setStatus("1"); // 已支付
        order.setPayTime(new Date());
        return updateBizOrder(order);
    }

    /**
     * 取消订单
     * 
     * @param orderId 订单ID
     * @return 结果
     */
    @Override
    @Transactional
    public int cancelOrder(Long orderId) {
        BizOrder order = new BizOrder();
        order.setId(orderId);
        order.setStatus("3"); // 已取消
        order.setEndTime(new Date());
        return updateBizOrder(order);
    }

    /**
     * 完成订单
     * 
     * @param orderId 订单ID
     * @return 结果
     */
    @Override
    @Transactional
    public int completeOrder(Long orderId) {
        BizOrder order = new BizOrder();
        order.setId(orderId);
        order.setStatus("2"); // 已完成
        order.setEndTime(new Date());
        return updateBizOrder(order);
    }

    /**
     * 生成订单编号
     * 
     * @return 订单编号
     */
    private String generateOrderNo() {
        return DateUtils.dateTimeNow() + StringUtils.makeRandomStr(4);
    }
} 