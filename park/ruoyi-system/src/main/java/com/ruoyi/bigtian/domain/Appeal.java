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
@TableName(value = "appeal")
    public class Appeal implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

    private Integer uid;

      /**
     * 申诉内容
     */
      private String content;

      /**
     * 申诉状态：0 未审核，1 申诉成功，2 申诉失败
     */
      private Integer status;

      /**
     * 申诉失败原因
     */
      private String reason;

    private Integer vid;

  @TableField(fill = FieldFill.INSERT)
    private Date appealTime;

    @TableField(fill = FieldFill.UPDATE)
    private Date doAppealTime;


}
