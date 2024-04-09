package com.cc.common;

import lombok.Getter;

/**
 * 订单状态枚举.
 */
@Getter
public enum OrderStatus {

    WAIT_PAYMENT (1, "待支付"),
    WAIT_DELIVERY(2, "待发货"),
    WAIT_RECEIVE(3, "待收货"),
    FINISH(4, "已完成");

    private final Integer key;
    private final String description;

    OrderStatus(Integer key, String description) {
        this.key = key;
        this.description = description;
    }

}
