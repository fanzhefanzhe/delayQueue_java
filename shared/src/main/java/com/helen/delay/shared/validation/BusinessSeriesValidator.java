package com.helen.delay.shared.validation;




import com.helen.delay.shared.constant.EBusinessCode;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.apache.commons.lang3.ObjectUtils.isEmpty;


/**
 * 业务类型验证器
 *
 * @author 张华彬
 * @since 1.0.0
 */
public class BusinessSeriesValidator implements ConstraintValidator<BusinessSeries, EBusinessCode> {

    /**
     * 业务码系列
     */
    private EBusinessCode.ESeries[] series;
    /**
     * 排除列表
     */
    private EBusinessCode.ESeries[] excludes;


    @Override
    public void initialize(BusinessSeries va) {
        series = va.value();
        excludes = va.excludes();
    }

    @Override
    public boolean isValid(EBusinessCode value, ConstraintValidatorContext context) {
        var ex = asList(excludes);
        var merged = Stream.of(series).filter(s -> !ex.contains(s)).toList();
        return isEmpty(merged) || merged.contains(value.getSeries());
    }

}
