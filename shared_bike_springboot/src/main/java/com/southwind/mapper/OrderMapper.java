package com.southwind.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.southwind.common.PayOrder;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<PayOrder> {
}