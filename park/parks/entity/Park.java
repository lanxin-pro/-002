package parks.entity;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Park {
    private Long id;
    private String name;
    private String pointDetail;
    private BigDecimal price;
    private Integer availableBikes;
    private String latitude;
    private String longitude;
    private String rates;
    private String atts;
    private String state;
} 