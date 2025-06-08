package com.ruoyi.system.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ruoyi.system.domain.BizOrder;
import java.util.List;

@Mapper
public interface BizOrderMapper {
    /**
     * 新增订单
     */
    public int insertOrder(BizOrder order);

    /**
     * 修改订单
     */
    public int updateOrder(BizOrder order);

    /**
     * 查询订单
     */
    public BizOrder selectOrderById(@Param("id") Long id);

    /**
     * 查询订单列表
     */
    public List<BizOrder> selectOrderList();

    /**
     * 根据用户ID查询订单列表
     */
    public List<BizOrder> selectOrdersByUserId(@Param("userId") Long userId);
} 
 