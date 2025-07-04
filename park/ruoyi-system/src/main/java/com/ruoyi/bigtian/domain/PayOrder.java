package com.ruoyi.bigtian.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 支付订单对象 t_pay_order
 *
 * @author bigtian
 * @date 2023-04-18
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "t_pay_order")
@ApiModel(value = "支付订单")
public class PayOrder {
    private static final long serialVersionUID = 1L;

    /**
     * $column.columnComment
     */
    @TableField(value = "id")
    @TableId(type = IdType.ASSIGN_ID)
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    /**
     * 支付用户
     */

    @Excel(name = "支付用户")
    @TableField(value = "user_id")
    @ApiModelProperty(value = "支付用户")
    private Long userId;

    /**
     * 停车场id
     */

    @Excel(name = "停车场id")
    @TableField(value = "park_id")
    @ApiModelProperty(value = "停车场id")
    private Long parkId;

    /**
     * 状态（0：未支付；1：已支付）
     */

    @Excel(name = "状态", readConverterExp = "0=：未支付；1：已支付")
    @TableField(value = "status")
    @ApiModelProperty(value = "状态（0：未支付；1：已支付）")
    private Long status;

    @TableField("create_time")
    private Date createTime;

    @Excel(name = "起点位置")
    @TableField(value = "start_point")
    @ApiModelProperty(value = "起点位置")
    private String startPoint;

    @Excel(name = "终点位置")
    @TableField(value = "end_point")
    @ApiModelProperty(value = "终点位置")
    private String endPoint;

    @Excel(name = "预计费用")
    @TableField(value = "estimated_cost")
    @ApiModelProperty(value = "预计费用")
    private BigDecimal estimatedCost;

    @Excel(name = "预计骑行时长")
    @TableField(value = "duration")
    @ApiModelProperty(value = "预计骑行时长(小时)")
    private Integer duration;

    @TableField(exist = false)
    private  String nickName;

    @TableField(exist = false)
    private  String parkName;

    @TableField(exist = false)
    private  String picUrl;

    @TableField(exist = false)
    private BigDecimal price;
}
