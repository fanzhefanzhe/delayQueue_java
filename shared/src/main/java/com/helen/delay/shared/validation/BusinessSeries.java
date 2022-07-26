package com.helen.delay.shared.validation;



import com.helen.delay.shared.constant.EBusinessCode;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


/**
 * 业务类型约束
 *
 * @author 张华彬
 * @since 1.0.0
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = BusinessSeriesValidator.class)
public @interface BusinessSeries {

    // <editor-fold defaultstate="collapsed" desc="JSR-303注解必须包含的属性">

    /**
     * 约束失败提示信息
     *
     * @return 提示信息
     */
    String message() default "业务类型不正确";

    /**
     * 分组
     *
     * @return 分组对应类列表
     */
    Class<?>[] groups() default {};

    /**
     * 负载
     *
     * @return 负载类
     */
    Class<? extends Payload>[] payload() default {};

    // </editor-fold>


    /**
     * 业务编码系列
     *
     * @return 系列列表
     */
    EBusinessCode.ESeries[] value() default {};

    /**
     * 业务编码排除系列
     *
     * @return 系列列表
     */
    EBusinessCode.ESeries[] excludes() default {};

}
