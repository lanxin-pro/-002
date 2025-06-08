package com.ruoyi.system.domain;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.common.core.domain.BaseEntity;

public class BizOrder extends BaseEntity {
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long parkId;
    private Long userId;
    private String destination;
    private Integer duration;
    private BigDecimal totalCost;
    private Integer status;  // 1:待支付 2:已支付 3:已完成 4:已取消

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setParkId(Long parkId) {
        this.parkId = parkId;
    }

    public Long getParkId() {
        return parkId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDestination() {
        return destination;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("parkId", getParkId())
            .append("userId", getUserId())
            .append("destination", getDestination())
            .append("duration", getDuration())
            .append("totalCost", getTotalCost())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
} 