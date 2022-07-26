package com.helen.delay.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import com.helen.delay.service.api.IPeopleService;
import com.helen.delay.service.delay.aop.annotation.Delay;
import com.helen.delay.service.model.People;
import com.helen.delay.service.repo.PeopleMapper;
import com.helen.delay.shared.domain.param.PeopleReq;
import com.helen.delay.shared.domain.vo.PeopleListVo;
import com.helen.delay.shared.enums.RedisDelayQueueEnum;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author: 樊喆
 */
@Slf4j
@Service
@AllArgsConstructor
public class PeopleServiceImpl extends ServiceImpl<PeopleMapper, People> implements IPeopleService {

    private PeopleMapper peopleMapper;

    @Override
    @Delay(code = RedisDelayQueueEnum.SINGLE_QUERY_IN_PROGRESS ,delay = 15 , timeUnit = TimeUnit.SECONDS)
    public People queryPeopleById(Long id) {
        return peopleMapper.selectById(id);
    }

    @Override
    public List<People> selectAll(PeopleReq peopleReq) {
        return peopleMapper.findList(peopleReq);
    }

    @Override
    @Delay(code = RedisDelayQueueEnum.BATCH_QUERY_IN_PROGRESS ,delay = 15 , timeUnit = TimeUnit.SECONDS)
    public PageInfo<PeopleListVo> selectAllPageInfo(PeopleReq peopleReq) {
        //开启分页
        PageMethod.startPage(peopleReq.getPageNumber(),peopleReq.getPageSize());
        //toPageInfo 为了解决转换实体类后分页失效情况（注意pagehelper版本）
        return peopleMapper.findList2(peopleReq)
                .toPageInfo(People::toPeopleVo);
    }

    //正常分页
    @Override
    public PageInfo<PeopleListVo> selectAllPageInfoOld(PeopleReq peopleReq) {
        //开启分页,如果实体发生变化，分页可能会失效，使用上面方案。如果没有变化可以使用此方案
        PageMethod.startPage(peopleReq.getPageNumber(),peopleReq.getPageSize());
        List<PeopleListVo> peopleListVos = peopleMapper.findList3(peopleReq)
                .stream().map(People::toPeopleVo).toList();
        return new PageInfo<>(peopleListVos);
    }

}
