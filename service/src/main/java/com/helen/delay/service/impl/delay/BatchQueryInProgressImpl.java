package com.helen.delay.service.impl.delay;

import com.helen.delay.service.api.IPeopleService;
import com.helen.delay.service.delay.RedisDelayQueueHandle;
import com.helen.delay.service.util.JsonUtil;
import com.helen.delay.shared.domain.param.PeopleReq;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 * @Author: 樊喆
 * @Description: 批量查询开始
 */
@Service("BATCH_QUERY_IN_PROGRESS")
@Slf4j
@AllArgsConstructor
public class BatchQueryInProgressImpl implements RedisDelayQueueHandle<String> {

    private IPeopleService peopleService;
    @Override
    public void execute(String peopleReq) {
        try {
            PeopleReq objByUnderlineToLowerCase = JsonUtil.getObjByUnderlineToLowerCase(peopleReq, PeopleReq.class);
            //调用 批量查询开始方法
            peopleService.selectAllPageInfo(objByUnderlineToLowerCase);
        }catch (RuntimeException e){
            log.error("批量查询开始处理异常 ",e);
        }
    }
}
