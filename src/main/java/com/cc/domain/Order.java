package com.cc.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cc.common.OrderStatus;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * 订单实体.
 */
@Data
@TableName("tb_order")
public class Order implements Serializable {

    /**
     * 主键.
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品名称.
     */
    private String name;

    /**
     * 商品价格.
     */
    private BigDecimal price;

    /**
     * 订单状态
     */
    private Integer status;
}
