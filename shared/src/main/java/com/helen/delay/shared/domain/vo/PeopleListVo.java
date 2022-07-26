package com.helen.delay.shared.domain.vo;

import com.helen.delay.shared.enums.StatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Author: 樊喆
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeopleListVo {
    private static final long serialVersionUID =  1L;

    /**
     * id
     */
    private Long id;

    /**
     * name
     */
    private String name;

    /**
     * 状态-1正常 2-隐藏
     */
    private StatusEnum status;

    /**
     * 出生日期
     */
    private LocalDateTime create_time;

}
