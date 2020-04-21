package com.zaichiyikou.starter.system.utils;

/**
 * 通用工具类
 * 
 * @author zaichiyikoua
 * @since 2020-4-21
 */
public class CommonUtils {
    /**
     * 判断对象是否为空
     * 
     * @param <T>
     * @param t
     * @return
     */
    public static <T> boolean isNotNull(T t) {
        return null != t;
    }

    /**
     * 判断字符串是否为空
     * 
     * @param str
     * @return
     */
    public static boolean isNotNull(String str) {
        return null != str || "".equals(str);
    }
}
