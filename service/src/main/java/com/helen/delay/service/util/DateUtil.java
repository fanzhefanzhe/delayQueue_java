package com.helen.delay.service.util;

import cn.hutool.core.util.ObjectUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * @ClassNAME DateUtils
 * @Description TODO
 * @Author wangzb@cheche365.com
 * @Date 2022/4/24 10:58 AM
 * @Version 1.0
 */
public class DateUtil {

    public static Integer getAutoAge(LocalDate effectiveDate, LocalDate registerDate){
        effectiveDate = ObjectUtil.isNull(effectiveDate)? LocalDate.now():effectiveDate;
        return (int)ChronoUnit.YEARS.between(registerDate, effectiveDate) + 1;
    }

    public static LocalDate strToLocalDate(String date, String fmt){
        fmt = ObjectUtil.isEmpty(fmt) ? "yyyy-MM-dd" : fmt;
        return LocalDate.parse(date, DateTimeFormatter.ofPattern(fmt));
    }

    public static String localDateToStr(LocalDate date, String fmt){
        fmt = ObjectUtil.isEmpty(fmt) ? "yyyy-MM-dd" : fmt;
        return date.format(DateTimeFormatter.ofPattern(fmt));
    }

    public static LocalDateTime strToLocalDateTime(String datetime, String fmt){
        fmt = ObjectUtil.isEmpty(fmt) ? "yyyy-MM-dd HH:mm:ss" : fmt;
        return LocalDateTime.parse(datetime, DateTimeFormatter.ofPattern(fmt));
    }

    public static String localDateTimeToStr(LocalDateTime date, String fmt){
        fmt = ObjectUtil.isEmpty(fmt) ? "yyyy-MM-dd HH:mm:ss" : fmt;
        return date.format(DateTimeFormatter.ofPattern(fmt));
    }

    public static String now(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }


    public static Long getDaysByExpiredTime(String expiredTime) {
        if (ObjectUtil.isNull(expiredTime))
            return 0L;
        return ChronoUnit.DAYS.between(LocalDate.now(), strToLocalDateTime(expiredTime, null).toLocalDate());
    }
}
