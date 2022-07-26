package com.helen.delay.service.delay.aop.aspect;

import com.helen.delay.service.delay.aop.annotation.Delay;
import com.helen.delay.service.util.JsonUtil;
import com.helen.delay.service.util.RedisDelayQueueUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: 樊喆
 */
@Component
@Aspect
@Slf4j
public class DelayUpdateAspect {

    @Autowired
    private RedisDelayQueueUtil redisDelayQueueUtil;

    @Pointcut("@annotation(com.helen.delay.service.delay.aop.annotation.Delay)")
    public void callAt(){}

    @Before("callAt() && @annotation(delay)")
    public void begin(JoinPoint point, Delay delay){
        //拦截的方法参数
        Object arg = point.getArgs()[delay.location()];
        String jsonStringByLowerCaseToUnderline = JsonUtil.getJsonStringByLowerCaseToUnderline(arg);
        redisDelayQueueUtil.addDelayQueue(delay.code().getCode(), jsonStringByLowerCaseToUnderline , delay.delay() , delay.timeUnit());

        // TODO: 2022/7/26 失败重试三次
        //判断是否重复执行
        //if (redisUtil.hexists(code,jsonStringByLowerCaseToUnderline)){
        //    int i = Integer.parseInt(redisUtil.hget(code, jsonStringByLowerCaseToUnderline));
        //    if (i >= retry){
        //        //添加到日志，手动处理
        //        log.info("已经重复执行{}次了，停止添加延迟队列!! code:{},jsonString:{}",i,code,jsonStringByLowerCaseToUnderline);
        //        return;
        //    }else {
        //        log.info("开始第{}次重试，code:{},jsonString:{}",i,code,jsonStringByLowerCaseToUnderline);
        //        redisUtil.hset(code,jsonStringByLowerCaseToUnderline,String.valueOf(i+1));
        //    }
        //}else {
        //    redisUtil.hset(code,jsonStringByLowerCaseToUnderline,"1");
        //}
    }
    @AfterReturning("callAt() && @annotation(delay)")
    public void after(JoinPoint point, Delay delay){
        String code = delay.code().getCode();
        Object arg = point.getArgs()[delay.location()];
        String jsonStringByLowerCaseToUnderline = JsonUtil.getJsonStringByLowerCaseToUnderline(arg);
        log.info("执行成功:code:{},jsonString:{}",code,jsonStringByLowerCaseToUnderline);
        redisDelayQueueUtil.removeDelayQueue(code,jsonStringByLowerCaseToUnderline);
    }

}

