package com.helen.delay.service.model.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * mybatis 时间父类
 *
 * @author hbq
 */
@Data
@EqualsAndHashCode(exclude = {"createTime", "updateTime"}, callSuper = true)
public class BaseTimeTrackEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;
    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
