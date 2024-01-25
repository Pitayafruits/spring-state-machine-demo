package com.cc.domain;

import lombok.Data;

import java.util.Date;

/**
 * task实体
 */
@Data
public class Task {

    /**
     * 主键
     */
    private Long id;

    /**
     * 任务内容
     */
    private String content;

    /**
     * 创建人id
     */
    private Long creatorId;

    /**
     * 责任人id
     */
    private Long managerId;
    /**
     * 开始时间
     */
    private Date startDate;

    /**
     * 结束时间
     */
    private Date endDate;

    /**
     * 完成状态 -> 0 待办 1 进行 2 验收 3 延期 4完成
     */
    private CompleteStatus completeStatus;
}
