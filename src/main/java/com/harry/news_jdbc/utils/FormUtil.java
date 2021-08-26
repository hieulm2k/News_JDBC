package com.harry.news_jdbc.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;

public class FormUtil {
    @SuppressWarnings("unchecked")
    public static <T> T toModel(Class<T> clazz, HttpServletRequest request) {
        T object = null;
        try {
            object = clazz.getDeclaredConstructor().newInstance();
            BeanUtils.populate(object, request.getParameterMap());
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException| InvocationTargetException e) {
            System.out.print(e.getMessage());
        }
        return object;
    }
}
