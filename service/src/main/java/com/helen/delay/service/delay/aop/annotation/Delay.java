package com.helen.delay.service.delay.aop.annotation;

import com.helen.delay.shared.enums.RedisDelayQueueEnum;
import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * @Author: 樊喆
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Delay {
    //延迟队列业务枚举
    RedisDelayQueueEnum code();

    //延时时间
    long delay() default 30;

    //时间单位
    TimeUnit timeUnit() default TimeUnit.MINUTES;

    //参数位置
    int location() default 0;

}
