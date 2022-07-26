package com.helen.delay.service.config;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @ClassNAME LocalDataTypeAdapter
 * @Description TODO
 * @Author wangzb@cheche365.com
 * @Date 2022/7/12 5:43 PM
 * @Version 1.0
 */
public class LocalDataTypeAdapter implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {

    @Override
    public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        if (!(jsonElement instanceof JsonPrimitive)){
            throw new JsonParseException("The date should be a string value");
        }
        return null;
    }

    @Override
    public JsonElement serialize(LocalDate localDate, Type type, JsonSerializationContext jsonSerializationContext) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String createTime = dateTimeFormatter.format(localDate);
        return new JsonPrimitive(createTime);
    }
}
