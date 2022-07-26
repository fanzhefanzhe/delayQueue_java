package com.helen.delay.service.delay;

import cn.hutool.extra.spring.SpringUtil;
import com.helen.delay.service.util.RedisDelayQueueUtil;
import com.helen.delay.shared.enums.RedisDelayQueueEnum;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: huibq
 * @Date: 2022/7/1 11:46
 * @Description: 启动延迟队列
 */
@Slf4j
@Component
@AllArgsConstructor
public class RedisDelayQueueRunner implements CommandLineRunner {
    private RedisDelayQueueUtil redisDelayQueueUtil;

    @Override
    public void run(String... args) {
        RedisDelayQueueEnum[] queueEnums = RedisDelayQueueEnum.values();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            queueEnums.length,
            queueEnums.length,
            0L,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingDeque<>(),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy()
        );
        log.info("【RedissonThreadPool线程池已经开启】");
        for (RedisDelayQueueEnum queueEnum : queueEnums) {
            log.info("【添加redis队列成功】:{}", queueEnum.getName());
            threadPoolExecutor.execute(() -> {
                try {
                    log.info("【redis监听器开始监听】:{}", queueEnum.getCode());
                    RedisDelayQueueHandle redisDelayQueueHandle = SpringUtil.getBean(queueEnum.getCode());
                    while (true) {
                        Object value = redisDelayQueueUtil.getDelayQueue(queueEnum.getCode());
                        redisDelayQueueHandle.execute(value);
                    }
                } catch (InterruptedException e) {
                    log.error("【Redis延迟队列异常中断】 {}", e.getMessage());
                }
            });
        }
        log.info("【Redis延迟队列启动成功】");
    }
}
