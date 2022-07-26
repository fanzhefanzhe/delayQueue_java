package com.helen.delay.shared.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Author: 樊喆
 * @Description: 延迟队列业务枚举
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum RedisDelayQueueEnum {


    SINGLE_QUERY_IN_PROGRESS("SINGLE_QUERY_IN_PROGRESS","单个查询开始"),

    BATCH_QUERY_IN_PROGRESS("BATCH_QUERY_IN_PROGRESS","批量查询开始");

    /**
     * 延迟队列 Redis Key
     */
    private String code;

    /**
     * 中文描述
     */
    private String name;
}
