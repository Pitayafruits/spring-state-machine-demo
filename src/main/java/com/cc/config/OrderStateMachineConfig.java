package com.cc.config;

import com.cc.common.OrderStatus;
import com.cc.common.OrderStatusChangeEvents;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import java.util.EnumSet;

/**
 * 订单状态机配置.
 */
@Configuration
@EnableStateMachine
public class OrderStateMachineConfig extends EnumStateMachineConfigurerAdapter<OrderStatus, OrderStatusChangeEvents> {

    /**
     * 初始化状态机状态.
     *
     * @param states 状态实例
     * @throws Exception 运行时异常.
     */
    @Override
    public void configure(StateMachineStateConfigurer<OrderStatus, OrderStatusChangeEvents> states) throws Exception {
        states
                .withStates()
                .initial(OrderStatus.WAIT_PAYMENT) //定义了初始状态为待支付
                .states(EnumSet.allOf(OrderStatus.class)); //指定OrderStatus中的所有状态作为该状态机的状态定义
    }

    /**
     * 配置订单状态机转换事件关系.
     *
     * @param transitions 状态机转换配置器
     * @throws Exception 运行时异常
     */
    @Override
    public void configure(StateMachineTransitionConfigurer<OrderStatus, OrderStatusChangeEvents> transitions)
            throws Exception {
        //来源状态为source，目标状态为target，触发事件为event
        transitions
                //支付事件：待支付->待发货
                .withExternal().source(OrderStatus.WAIT_PAYMENT).target(OrderStatus.WAIT_DELIVERY).event(OrderStatusChangeEvents.PAYED)
                .and()
                //发货事件：待发货->待收货
                .withExternal().source(OrderStatus.WAIT_DELIVERY).target(OrderStatus.WAIT_RECEIVE).event(OrderStatusChangeEvents.DELIVERY)
                .and()
                //收货事件：待收货->已完成
                .withExternal().source(OrderStatus.WAIT_RECEIVE).target(OrderStatus.FINISH).event(OrderStatusChangeEvents.RECEIVED)
                .and()
                //退货事件：待收货->待发货
                .withExternal().source(OrderStatus.WAIT_RECEIVE).target(OrderStatus.WAIT_DELIVERY).event(OrderStatusChangeEvents.REJECTED);
    }

}
