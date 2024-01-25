package com.cc.config;

import com.cc.domain.CompleteStatus;
import com.cc.domain.TaskEvents;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;

@Configuration
@EnableStateMachine
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<CompleteStatus, TaskEvents> {

    // 初始化当前状态机拥有哪些状态
    @Override
    public void configure(StateMachineStateConfigurer<CompleteStatus, TaskEvents> states) throws Exception {
        states.withStates().initial(CompleteStatus.DOING) //定义了初始状态为进行中
                .states(EnumSet.allOf(CompleteStatus.class)); //指定States中的所有状态作为该状态机的状态定义
    }

    // 初始化当前状态机有哪些状态迁移动作
    // 有来源状态为source，目标状态为target，触发事件为event
    @Override
    public void configure(StateMachineTransitionConfigurer<CompleteStatus, TaskEvents> transitions)
            throws Exception {
        transitions
                .withExternal()
                .source(CompleteStatus.DOING).target(CompleteStatus.CHECK)
                .event(TaskEvents.COMMIT) //提交事件将触发：进行中状态->待验收状态
                .and()
                .withExternal()
                .source(CompleteStatus.CHECK).target(CompleteStatus.FINISH)
                .event(TaskEvents.GRADE); // 打分事件将触发：待验收状态->完成状态
    }

}
