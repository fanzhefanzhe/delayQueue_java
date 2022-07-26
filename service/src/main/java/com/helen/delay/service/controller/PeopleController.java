package com.helen.delay.service.controller;

import com.helen.delay.service.api.IPeopleService;
import com.helen.delay.service.model.People;
import com.helen.delay.service.model.response.DResponse;
import com.helen.delay.service.model.response.Result;
import com.helen.delay.shared.domain.base.PageResult;
import com.helen.delay.shared.domain.param.PeopleReq;
import com.helen.delay.shared.domain.vo.PeopleListVo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @Author: 樊喆
 */

@Slf4j
@RestController
@RequestMapping(value = "/helen/people", produces = APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class PeopleController {

    private IPeopleService peopleService;

    @PostMapping(value = "")
    List<People> queryPeopleList(@Valid PeopleReq peopleReq){
        return peopleService.selectAll(peopleReq);
    }

    @GetMapping(value = "/{id}")
    People queryPeople(@PathVariable("id") Long id){
        return peopleService.queryPeopleById(id);
    }

    @PostMapping(value = "pageInfo")
    DResponse<PageResult<PeopleListVo>> queryPeoplePageInfo(@Valid PeopleReq peopleReq){
        return Result.success(peopleService.selectAllPageInfo(peopleReq));
    }

    @PostMapping(value = "pageInfoOld")
    DResponse<PageResult<PeopleListVo>> queryPeoplePageInfoOld(@Valid PeopleReq peopleReq){
        return Result.success(peopleService.selectAllPageInfoOld(peopleReq));
    }

}
