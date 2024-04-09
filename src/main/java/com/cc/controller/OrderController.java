package com.cc.controller;

import com.cc.base.BaseResponse;
import com.cc.domain.Order;
import com.cc.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单Controller.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    /**
     * 创建订单
     * @param order 订单信息
     * @return 订单信息
     */
    @PostMapping
    public ResponseEntity<Object> create(@RequestBody Order order) {
        Order orderResponse = orderService.create(order);
        return new ResponseEntity<>(new BaseResponse<>(orderResponse), HttpStatus.OK);
    }
}
