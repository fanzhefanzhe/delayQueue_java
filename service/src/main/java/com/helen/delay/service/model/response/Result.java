package com.helen.delay.service.model.response;


import com.helen.delay.shared.constant.EBusinessCode;
import com.helen.delay.shared.domain.base.PageResult;
import com.github.pagehelper.PageInfo;
import com.helen.delay.shared.validation.BusinessSeries;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

import static com.helen.delay.shared.constant.EBusinessCode.ESeries._SUCCESS_SERIES;
import static com.helen.delay.shared.constant.EBusinessCode._SUCCESS;


/**
 * DTO实用工具
 *
 * @author 张华彬
 * @since 1.0.0
 */
public class Result {


    // <editor-fold defaultstate="collapsed" desc="DResponse方便方法">

    /**
     * 生成成功响应
     * @return 响应
     */
    public static DResponse<?> success() {
        return success(_SUCCESS, null, _SUCCESS.getDescription(), null);
    }

    /**
     * 生成成功响应
     *
     * @param message 提示信息
     * @return 响应
     */
    public static DResponse<?> success(String message) {
        return success(_SUCCESS, null, message, null);
    }

    /**
     * 生成成功响应
     *
     * @param payload 负载
     * @param message 提示信息
     * @return 响应
     */
    public static <R> DResponse<R> success(R payload, String message) {
        return success(_SUCCESS, payload, message, null);
    }

    /**
     * 生成成功响应
     *
     * @param payload 负载
     * @return 响应
     */
    public static <R> DResponse<R> success(R payload) {
        return success(_SUCCESS, payload, _SUCCESS.getDescription(), null);
    }

    /**
     * 生成成功响应
     *
     * @param businessCode 业务码
     * @param message      提示信息
     * @return 响应
     */
    public static DResponse<?> success(EBusinessCode businessCode, String message) {
        return success(businessCode, null, message, null);
    }

    /**
     * 生成成功响应
     *
     * @param businessCode 业务码
     * @param payload      负载
     * @param message      提示信息
     * @param metadata     元数据
     * @return 响应
     */
    public static <R> DResponse<R> success(
        @BusinessSeries(_SUCCESS_SERIES) EBusinessCode businessCode,
        R payload,
        String message,
        Map<String, ?> metadata
    ) {
        return new DResponse<>(businessCode.getId(), payload, message, metadata);
    }

    /**
     * 生成错误响应
     *
     * @param businessCode 业务码
     * @return 响应
     */
    public static DResponse error(EBusinessCode businessCode) {
        return error(businessCode, null, businessCode.getDescription(), null);
    }

    /**
     * 生成错误响应
     *
     * @param businessCode 业务码
     * @param message      提示信息
     * @return 响应
     */
    public static DResponse<?> error(EBusinessCode businessCode, String message) {
        return error(businessCode, null, StringUtils.isNotBlank(message) ? message : businessCode.getDescription(), null);
    }

    /**
     * 生成错误响应
     *
     * @param businessCode 业务码
     * @param payload      负载
     * @param message      提示信息
     * @param metadata     元数据
     * @return 响应
     */
    public static <R> DResponse<R> error(
        @BusinessSeries(excludes = _SUCCESS_SERIES) EBusinessCode businessCode,
        R payload,
        String message,
        Map<String, ?> metadata
    ) {
        return new DResponse<>(businessCode.getId(), payload, message, metadata);
    }

    /**
     * 分页结果转换
     * @param list 分页数据
     * @param <T>   泛型
     * @return  分页结果
     */
    public static <T> DResponse<PageResult<T>> success(PageInfo<T> list) {
        return new DResponse<>(_SUCCESS.getId(), PageResult.restPage(list), _SUCCESS.getDescription(), null);
    }

    // </editor-fold>

}
