package com.helen.delay.service.api;

import com.github.pagehelper.PageInfo;
import com.helen.delay.service.model.People;
import com.helen.delay.shared.domain.param.PeopleReq;
import com.helen.delay.shared.domain.vo.PeopleListVo;

import java.util.List;

/**
 * @Author: 樊喆
 */
public interface IPeopleService {

    People queryPeopleById(Long id);

    List<People> selectAll(PeopleReq peopleReq);

    PageInfo<PeopleListVo> selectAllPageInfo(PeopleReq peopleReq);

    PageInfo<PeopleListVo> selectAllPageInfoOld(PeopleReq peopleReq);

}
