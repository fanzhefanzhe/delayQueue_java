package com.helen.delay.service.util;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RBlockingDeque;
import org.redisson.api.RDelayedQueue;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Author: huibq
 * @Date: 2022/7/1 11:45
 * @Description: redis延迟队列工具
 */
@Slf4j
@Component
@AllArgsConstructor
public class RedisDelayQueueUtil {

    private RedissonClient redissonClient;

    /**
     * 添加延迟队列
     *
     * @param value     队列值
     * @param delay     延迟时间
     * @param timeUnit  时间单位
     * @param queueCode 队列键
     * @param <T>
     */
    public <T> void addDelayQueue(String queueCode, T value, long delay, TimeUnit timeUnit) {
        RBlockingDeque<Object> blockingDeque = redissonClient.getBlockingDeque(queueCode);
        RDelayedQueue<Object> delayedQueue = redissonClient.getDelayedQueue(blockingDeque);
        delayedQueue.offer(value, delay, timeUnit);
        log.info("(添加延时队列成功) 队列键：{}，队列值：{}，延迟时间：{}", queueCode, value, timeUnit.toSeconds(delay) + "秒");
    }

    /**
     * 获取延迟队列
     */
    public <T> T getDelayQueue(String queueCode) throws InterruptedException {
        RBlockingDeque<Map> blockingDeque = redissonClient.getBlockingDeque(queueCode);
        T value = (T) blockingDeque.take();
        log.info("(收到队列消息) 队列键：{}，队列值：{}", queueCode, value);
        return value;
    }

    /**
     * 删除延迟队列
     */
    public <T> void removeDelayQueue(String queueCode, T value) {
        RBlockingDeque<Map> blockingDeque = redissonClient.getBlockingDeque(queueCode);
        log.info("(删除队列消息) 队列键：{}，队列值：{}", queueCode, value);
        redissonClient.getDelayedQueue(blockingDeque).remove(value);
    }

}
