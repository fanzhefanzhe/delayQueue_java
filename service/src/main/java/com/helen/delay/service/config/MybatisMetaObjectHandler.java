package com.helen.delay.service.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.helen.delay.shared.enums.IsDeletedEnum;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @Author: hbq
 * @Description: mybatis-plus 自动填充
 * @Date: 2021/12/7 14:10
 */
@Component
public class MybatisMetaObjectHandler implements MetaObjectHandler {
    private final static String UPDATE_TIME = "updateTime";
    private final static String CREATE_TIME = "createTime";
    private final static String IS_DELETED = "isDeleted";

    /**
     * 插入填充，字段为空自动填充
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        Object createTime = getFieldValByName(CREATE_TIME, metaObject);
        Object updateTime = getFieldValByName(UPDATE_TIME, metaObject);
        Object isDeleted = getFieldValByName(IS_DELETED, metaObject);
        if (createTime == null || updateTime == null || isDeleted == null) {
            if (createTime == null) {
                setFieldValByName(CREATE_TIME, LocalDateTime.now(), metaObject);
            }
            if (updateTime == null) {
                setFieldValByName(UPDATE_TIME, LocalDateTime.now(), metaObject);
            }
            if (isDeleted == null) {
                setFieldValByName(IS_DELETED, IsDeletedEnum.NO_DELETED.getCode(), metaObject);
            }
        }
    }

    /**
     * 更新填充
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        setFieldValByName(UPDATE_TIME, LocalDateTime.now(), metaObject);
    }
}
