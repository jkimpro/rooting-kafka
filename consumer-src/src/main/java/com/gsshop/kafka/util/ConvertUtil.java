package com.gsshop.kafka.util;

import com.google.common.base.CaseFormat;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotNull;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class ConvertUtil {

    @NotNull
    public static Map<String, Object> camelVoToSnakeMap(Object o) {
        return camelVoToSnakeMap(o, false, true);
    }

    @NotNull
    public static Map<String, Object> camelVoToSnakeMap(Object o, boolean isUpperCase) {
        return camelVoToSnakeMap(o, false, isUpperCase);
    }

    @NotNull
    public static Map<String, Object> camelVoToSnakeMap(Object o, boolean nullable, boolean isUpperCase) {
        Map<String, Object> fields = new HashMap<>();

        for (Field field : o.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            String underscore = isUpperCase ? CaseFormat.UPPER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, fieldName) : CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, fieldName);
            Object value = null;

            try {
                Method getter = o.getClass().getMethod("get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1));
                value = getter.invoke(o);
            } catch (NoSuchMethodException | IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
                log.warn(e.getMessage(), e);
            }

            if (nullable || (!nullable && value != null)) {
                fields.put(underscore, value);
            }
        }

        return fields;
    }

    @NotNull
    public static Map<String, Object> camelVoToCamelMap(Object o) {
        return camelVoToCamelMap(o, false);
    }

    @NotNull
    public static Map<String, Object> camelVoToCamelMap(Object o, boolean nullable) {
        Map<String, Object> fields = new HashMap<>();

        for (Field field : o.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object value = null;

            try {
                Method getter = o.getClass().getMethod("get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1));
                value = getter.invoke(o);
            } catch (NoSuchMethodException | IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
                log.warn(e.getMessage(), e);
            }

            if (nullable || (!nullable && value != null)) {
                fields.put(fieldName, value);
            }
        }

        return fields;
    }

    @NotNull
    public static Map<String, Object> snakeMapToCamelMap(Map<String, Object> fields) {
        Map<String, Object> result = new HashMap<>();

        for (String key : fields.keySet()) {
            Object value = fields.get(key);
            String camelKey = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, key);
            result.put(camelKey, value);
        }

        return result;
    }
}
