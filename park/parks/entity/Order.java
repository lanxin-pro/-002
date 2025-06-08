package parks.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Order {
    private Long id;
    private Long parkId;
    private Long userId;
    private String destination;
    private Integer duration;
    private BigDecimal totalCost;
    private Integer status; // 1:待支付 2:已支付 3:已完成 4:已取消
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
} 