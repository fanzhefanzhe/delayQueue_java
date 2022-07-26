package com.helen.delay.shared.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum IsDeletedEnum {
    /**
     * 删除
     */
    DELETED (1, "已删除"),
    /**
     * 未删除
     */
    NO_DELETED (0, "未删除");

    private int code;
    private String desc;

}
