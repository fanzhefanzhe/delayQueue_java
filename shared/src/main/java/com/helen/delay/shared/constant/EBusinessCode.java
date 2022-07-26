package com.helen.delay.shared.constant;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.stream.Stream;

import static com.helen.delay.shared.constant.EBusinessCode.ESeries.*;


/**
 * 业务编码
 * @author 张
 */
@Getter
public enum EBusinessCode {

    //<editor-fold defaultstate="collapsed" desc="xxx Success">
    _SUCCESS(0, "成功"),
    _CONDITIONAL_SUCCESS(10, "有条件的成功"),
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="1xxx Validation Error">
    _DATA_VALIDATION_ERROR(1000, "数据验证异常"),
    _CONSTRAINT_VIOLATION_ERROR(1010, "自定义约束背反"),
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="2xxx Authentication Error">
    _AUTHENTICATION_ERROR(2000, "认证异常"),
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="3xxx Authorization Error">
    _AUTHORIZATION_ERROR(3000, "授权异常"),
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="4xxx Client Error">
    _CLIENT_ERROR(4000, "客户端异常"),
    _NOT_FOUND_ERROR(4010, "无法找到相应资源"),
    _SIGNATURE_ERROR(4020, "验签失败"),
    _INVALID_FORMAT_ERROR(4030, "无效格式"),
    _VIN_QUERY_POLICY_NO_RESULT(4040, "VIN码查询承保无结果"),
    _REPEAT_SUBMIT_ERROR(4050, "重复提交"),
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="5xxx Server Internal Error">
    _INTERNAL_ERROR(5000, "服务端内部异常"),
    _BUSINESS_ERROR(5010, "业务异常"),
    _SYSTEM_ERROR(5020, "系统异常"),
    _DATA_CONSISTENCY_ERROR(5030, "数据一致性异常"),
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="6xxx Server External Error">
    _EXTERNAL_ERROR(6000, "服务端外部异常");
    //</editor-fold>


    /**
     * ID
     */
    private final long id;
    /**
     * 描述
     */
    private final String description;


    EBusinessCode(long id, String description) {
        this.id = id;
        this.description = description;
    }


    static EBusinessCode of(long businessCode) {
        return Stream.of(values()).filter(v -> businessCode == v.toValue()).findFirst().orElseThrow();
    }

    @JsonValue
    public long toValue() {
        return id;
    }

    public ESeries getSeries() {
        return ESeries.of(this);
    }

    public boolean isSuccess() {
        return getSeries() == _SUCCESS_SERIES;
    }

    public boolean isDataValidationError() {
        return getSeries() == _DATA_VALIDATION_SERIES;
    }

    public boolean isAuthenticationError() {
        return getSeries() == _AUTHENTICATION_SERIES;
    }

    public boolean isAuthorizationError() {
        return getSeries() == _AUTHORIZATION_SERIES;
    }

    public boolean isClientError() {
        return getSeries() == _CLIENT_SERIES;
    }

    public boolean isInternalError() {
        return getSeries() == _INTERNAL_SERIES;
    }

    public boolean isExternalError() {
        return getSeries() == _EXTERNAL_SERIES;
    }

    public boolean isError() {
        return isDataValidationError() || isAuthenticationError() || isAuthorizationError() ||
            isClientError() || isInternalError() || isExternalError();
    }

    /**
     * 业务状态系列枚举
     */
    public enum ESeries {

        _SUCCESS_SERIES(0, "成功"),
        _DATA_VALIDATION_SERIES(1, "数据验证"),
        _AUTHENTICATION_SERIES(2, "认证"),
        _AUTHORIZATION_SERIES(3, "授权"),
        _CLIENT_SERIES(4, "客户端"),
        _INTERNAL_SERIES(5, "服务端内部"),
        _EXTERNAL_SERIES(6, "服务端外部");


        /**
         * ID
         */
        private final long id;
        /**
         * 描述
         */
        private final String description;


        ESeries(long id, String description) {
            this.id = id;
            this.description = description;
        }

        @JsonValue
        public long toValue() {
            return id;
        }

        public static ESeries of(EBusinessCode businessCode) {
            return of(businessCode.id);
        }

        public static ESeries of(long businessCode) {
            var seriesCode = Long.valueOf(businessCode / 1000);
            return Stream.of(values()).filter(v -> seriesCode == v.toValue()).findFirst().orElseThrow();
        }

    }

}
