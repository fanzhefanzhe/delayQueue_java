package com.helen.delay.shared.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum StatusEnum {
    /**
     * 删除
     */
    NORMAL (1, "正常"),
    /**
     * 未删除
     */
    HIDE (2, "隐藏");

    private int code;
    private String desc;

}
