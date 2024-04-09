package com.cc.service;

import com.cc.domain.Order;

/**
 * 订单Service.
 */
public interface OrderService {

    /**
     * 创建订单
     * @param order 订单信息
     * @return 订单信息
     */
    Order create(Order order);
}
