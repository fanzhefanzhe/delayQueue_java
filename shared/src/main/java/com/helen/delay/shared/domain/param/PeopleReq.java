package com.helen.delay.shared.domain.param;

import com.helen.delay.shared.domain.base.PageReq;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @Author: 樊喆
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PeopleReq extends PageReq {
    private static final long serialVersionUID = 1L;

    /**
     * name
     */
    private String name;

    /**
     * 是否删除
     */
    private Integer isDeleted;

    /**
     * 开始时间
     */
    private String create_time;

}
