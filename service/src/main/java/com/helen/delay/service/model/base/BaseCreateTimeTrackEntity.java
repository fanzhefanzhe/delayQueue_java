package com.helen.delay.service.model.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * mybatis 创建时间父类
 *
 * @author hbq
 */
@Data
@EqualsAndHashCode(exclude = {"createTime"}, callSuper = true)
public class BaseCreateTimeTrackEntity extends BaseEntity {
    private static final long serialVersionUID = 1L;
    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;
}
