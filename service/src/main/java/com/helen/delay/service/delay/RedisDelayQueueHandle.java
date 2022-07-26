package com.helen.delay.service.delay;

/**
 * @Author: huibq
 * @Date: 2022/7/1 11:46
 * @Description: 延迟队列执行器
 */
public interface RedisDelayQueueHandle<T> {

	void execute(T t);

}
