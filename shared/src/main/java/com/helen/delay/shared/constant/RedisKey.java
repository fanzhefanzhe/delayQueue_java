package com.helen.delay.shared.constant;

public class RedisKey {
    /**
     * 租户资源
     * @param1 租户id
     * @param2 资源类型
     */
    public static final String TENANT_RESOURCE_KEY = "TENANT_%s_RESOURCE_%s";
    /**
     * 租户资源剩余量
     */
    public static final String TENANT_RESOURCE_BALANCE_HASH_KEY = "balance";
    /**
     * 租户资源剩余量消费单位
     */
    public static final String TENANT_RESOURCE_CONSUMPTION_MODE_HASH_KEY = "consumption_mode";
    /**
     * 租户资源到期日期
     */
    public static final String TENANT_RESOURCE_EXPIRED_TIME_HASH_KEY = "expired_time";
    /**
     * 赔付分中位值 key
     * @param1 地区id
     */
    public static final String SODA_RISK_MID_RATIO_KEY = "SODA_RISK_MID_RATIO_%s";
    /**
     * 赔付分中位值 hashKey
     * @param1 todo
     */
    public static final String SODA_RISK_MID_RATIO_RISK_HASH_KEY = "risk_%s_summary";
    /**
     * 风险报告请求
     */
    public static final String RISK_REPORT_GENERATOR_QUEUE_NAME = "nier_risk_report_generator_queue";
    /**
     * 风险报告结果
     */
    public static final String RISK_REPORT_GENERATOR_RESULT_QUEUE_NAME = "nier_risk_report_generator_result_queue";
    /**
     * 资源消耗日志
     */
    public static final String COMSUMPTION_RESOURCE_LOG_KEY = "COMSUMPTION_RESOURCE_%s_LOG";
    /**
     * 理赔请求消息队列key
     */
    public static final String RISK_CLAIM_GENERATOR_QUEUE_NAME = "nier_risk_claim_generator_queue";
    /**
     * 理赔结果消息队列key
     */
    public static final String RISK_CLAIM_RESULT_QUEUE_NAME = "nier_risk_claim_result_queue";
    /**
     * 重复提交key
     */
    public static final String NO_REPEAT_LOCK_PREFIX = "nier_no_repeat_lock:";
}
