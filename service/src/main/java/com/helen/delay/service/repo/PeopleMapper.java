package com.helen.delay.service.repo;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.helen.delay.service.model.People;
import com.helen.delay.shared.domain.param.PeopleReq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * @Author: 樊喆
 */
@Mapper
public interface PeopleMapper extends BaseMapper<People> {
    List<People> findList(@Param("p")PeopleReq peopleReq);

    Page<People> findList2(@Param("p")PeopleReq peopleReq);

    List<People> findList3(@Param("p")PeopleReq peopleReq);

}
