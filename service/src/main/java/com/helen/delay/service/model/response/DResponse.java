package com.helen.delay.service.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;


/**
 * 标准响应格式
 *
 * @author 张华彬
 * @since 1.0.0
 */
public record DResponse<T>(

    // <editor-fold defaultstate="collapsed" desc="核心属性">

    /*
     * 业务编码（注意：不是HTTP状态码）
     */
    long code,
    /*
     * 负载
     */
    @JsonInclude(NON_NULL)
    T payload,
    /*
     * 提示信息
     */
    @JsonInclude(NON_NULL)
    String message,

    /*
      元数据
     */
    @JsonInclude(NON_NULL)
    Map<String, ?> metadata

    // </editor-fold>

) {}
