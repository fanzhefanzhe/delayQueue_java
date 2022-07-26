package com.helen.delay.service.util;


import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.helen.delay.service.config.LocalDataTypeAdapter;

import java.time.LocalDate;

/**
 * @ClassNAME JsonUtils
 * @Description TODO
 * @Author wangzb@cheche365.com
 * @Date 2022/4/26 5:21 PM
 * @Version 1.0
 */
public class JsonUtil {

    public static String getJsonStringByLowerCaseToUnderline(Object obj){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        gsonBuilder.setDateFormat("yyyy-MM-dd");
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDataTypeAdapter());
        Gson gson = gsonBuilder.create();
        return gson.toJson(obj);
    }

    public static <T> T getObjByUnderlineToLowerCase(String message, Class<T> t){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        Gson gson = gsonBuilder.create();
        return gson.fromJson(message, t);
    }

}
