package com.helen.delay.service.model;

/**
 * @Author: 樊喆
 */
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.helen.delay.service.model.base.BaseTimeTrackEntity;
import com.helen.delay.shared.domain.vo.PeopleListVo;
import com.helen.delay.shared.enums.StatusEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@TableName(value = "people")
public class People extends BaseTimeTrackEntity {
    private static final long serialVersionUID =  1L;

    @TableField(value = "id")
    private Long id;

    @TableField(value = "name")
    private String name;

    /**
     * 状态-1正常 2-隐藏
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 是否删除 0 未删除 1 已删除
     */
    @TableLogic
    @TableField(value = "is_deleted", fill = FieldFill.INSERT)
    private Integer isDeleted;

    public PeopleListVo toPeopleVo(){
        PeopleListVo peopleListVo = new PeopleListVo();
        peopleListVo.setId(getId());
        peopleListVo.setName(getName());
        peopleListVo.setCreate_time(getCreateTime());
        peopleListVo.setStatus(StatusEnum.values()[getStatus()]);
        return peopleListVo;
    }
}
