package com.ruoyi.bigtian.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author admin
 * @since 2024-05-07
 */
@Data
  @EqualsAndHashCode(callSuper = false)
@TableName(value = "bike")
    public class Bike implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      /**
     * 编号
     */
      private String number;

      /**
     * 所属区域编号
     */
      private Integer aid;

      /**
     * 位置经度

     */
      private Float lng;

      /**
     * 位置纬度
     */
      private Float lat;

      /**
     * 押金
     */
      private String deposit;

  @TableField(fill = FieldFill.INSERT)
    private Date createTime;


}
