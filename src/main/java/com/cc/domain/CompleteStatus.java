package com.cc.domain;


import lombok.Getter;

/**
 * 任务完成状态枚举
 */

@Getter
public enum CompleteStatus {

    TODO (0, "未开始"),
    DOING(1, "进行中"),
    CHECK(2, "待验收"),
    DELAY(3, "延期中"),
    FINISH(4, "已完成");

    private final int value;
    private final String description;

    CompleteStatus(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public static CompleteStatus fromValue(int value) {
        for (CompleteStatus status : CompleteStatus.values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid value: " + value);
    }

}
