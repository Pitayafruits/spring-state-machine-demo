package com.cc.common;

/**
 * 订单状态变更事件枚举.
 */
public enum OrderStatusChangeEvents {

    PAYED, //支付

    DELIVERY, //发货

    RECEIVED, //确认收货

    REJECTED; //退货

}
