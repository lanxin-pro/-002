package com.ruoyi.bigtian.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
  @EqualsAndHashCode(callSuper = false)
@TableName(value = "area")
    public class Area implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      /**
     * 监管人员编号
     */
      private Integer aid;

      /**
     * 停放区域
     */
      private String area;

      /**
     * 左下角经度
     */
      private Float leftlng;

      /**
     * 左下角纬度
     */
      private Float leftlat;

      /**
     * 右上角经度
     */
      private Float rightlng;

      /**
     * 右上角纬度
     */
      private Float rightlat;

      /**
     * 收费标准/小时
     */
      private Integer price;


}
