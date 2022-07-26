package com.helen.delay.shared.domain.base;

import lombok.Data;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.lang.Nullable;
import javax.validation.constraints.NotNull;


/**
 * @Author: 樊喆
 */
@Data
public class PageResult<T> {

    private final Integer page;
    private final Integer pageSize;
    private final Long totalCount;
    private final List<T> item;

    private PageResult(@NotNull Integer pageNum, @NotNull Integer pageSize, @NotNull Long total, @Nullable List<T> list) {
        this.page = pageNum;
        this.pageSize = pageSize;
        this.totalCount = total;
        this.item = list;
    }


    public static <T> PageResult<T> restPage(@NotNull Integer pageNum, @NotNull Integer pageSize, @NotNull Long total, @Nullable List<T> list) {
        return new PageResult<>(pageNum, pageSize, total, Optional.ofNullable(list).orElse(Collections.emptyList()));
    }

    /**
     * 将MyBatis Plus page分页结果转化为通用结果
     */
    public static <T> PageResult<T> restPage(@NotNull Page<T> page) {
        return new PageResult<>(page.getPageNum(), page.getPageSize(), page.getTotal(), page.getResult());
    }

    /**
     * 将MyBatis Plus pageInfo分页结果转化为通用结果
     */
    public static <T> PageResult<T> restPage(@NotNull PageInfo<T> page) {
        return new PageResult<>(page.getPageNum(), page.getPageSize(), page.getTotal(), page.getList());
    }

}

