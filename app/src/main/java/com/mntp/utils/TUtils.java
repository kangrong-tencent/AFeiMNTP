package com.mntp.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * 泛型实例化
 * 作者：kc on 2017/02/04.
 * qq：742174283.
 */
public class TUtils {

    public static <T> T getT(Object o) {
        try {
            Type type = o.getClass().getGenericSuperclass();
            Type trueType = ((ParameterizedType) type).getActualTypeArguments()[0];
            return ((Class<T>) trueType).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Class<?> forName(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
