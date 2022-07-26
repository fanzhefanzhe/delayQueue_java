package com.helen.delay.service.impl.delay;

import com.helen.delay.service.api.IPeopleService;
import com.helen.delay.service.delay.RedisDelayQueueHandle;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 * @Author: 樊喆
 * @Description: 单个查询开始
 */
@Service("SINGLE_QUERY_IN_PROGRESS")
@Slf4j
@AllArgsConstructor
public class SingleQueryInProgressImpl implements RedisDelayQueueHandle<String> {

    private IPeopleService peopleService;
    @Override
    public void execute(String id) {
        try {
            //调用 单个查询 方法
            peopleService.queryPeopleById(Long.parseLong(id));
        }catch (RuntimeException e){
            log.error("单个查询 处理异常 ",e);
        }
    }
}
