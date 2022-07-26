package com.helen.delay.shared.domain.base;

import com.helen.delay.shared.constant.PageConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @Author: 樊喆
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class PageReq {
    //当前页码(默认为1)
    public Integer pageNumber = PageConstants.DEF_PAGE_NUM;
    //每页条数(默认为10)
    public Integer pageSize = PageConstants.DEF_PAGE_SIZE;
}

