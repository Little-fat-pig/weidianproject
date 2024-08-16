package com.example.loginmodule.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/**
 * <p>校验类</p>
 *
 * @author xiaqianqian 2020/8/26 13:55
 */
public class ValidateUtils {
    private ValidateUtils() {
    }

    public static boolean isEmpty(Object str) {
        return str == null || "".equals(str);
    }

    public static boolean notEmpty(Object str) {
        return !isEmpty(str);
    }

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean notEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public static boolean notEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }

    public static boolean isEmpty(Object[] array) {
        return getLength(array) == 0;
    }

    private static int getLength(Object[] array) {
        return array == null ? 0 : Array.getLength(array);
    }

    public static boolean notEmpty(Object[] array) {
        return !isEmpty(array);
    }
}
