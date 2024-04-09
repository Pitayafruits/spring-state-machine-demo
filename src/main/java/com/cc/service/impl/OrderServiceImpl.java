package com.cc.service.impl;

import com.cc.common.OrderStatus;
import com.cc.domain.Order;
import com.cc.mapper.OrderMapper;
import com.cc.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 订单ServiceImpl
 */
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderMapper orderMapper;

    @Override
    public Order create(Order order) {
        int result = orderMapper.insert(order);
        if (result > 0) {
            return order;
        }
        return null;
    }
}
