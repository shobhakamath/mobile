package com.mobile.utils;

import com.mobile.entities.Brand;
import com.mobile.entities.Hardware;
import com.mobile.entities.Release;
import com.mobile.exception.ConfigurationException;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * This class contains utility methods of the application.
 *
 * @author shobha
 * @version 1.0
 */
public final class MobileUtils {

    public final static Predicate<String> isHardware = name -> (name.equals(Hardware.class.getSimpleName()));
    public final static Predicate<String> isRelease = name -> (name.equals(Release.class.getSimpleName()));

    /**
     * Private constructor to prevent instantiation.
     */
    private MobileUtils() {
    }


    public static void checkNull(Object value, String name) {
        if (value == null) {
            // Log exception
            throw new ConfigurationException("'" + name + "' should not be null.");
        }
    }

    /**
     * Filter the mobile data based on criteria
     * @param brands
     * @param requestParams
     * @return
     */
    public static List<Brand> filterCriteria(Brand[] brands, Map<String, String> requestParams) {
        return Arrays.stream(brands).
                filter(brand ->
                        validateRequestParamsRecursively(requestParams, brand))
                .collect(Collectors.toList());


    }

    /**
     * Validate the request parameters recursively
     * @param requestParamFound
     * @param class1
     * @return
     */
    public static boolean validateRequestParamsRecursively(Map<String, String> requestParamFound,
                                                           Object class1) {
        Field[] fields = class1.getClass().getDeclaredFields();
        boolean isValid = true;
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                if (isRelease.test(field.getType().getSimpleName()) || isHardware.test(field.getType().getSimpleName())) {
                    isValid = isValid && validateRequestParamsRecursively(requestParamFound, field.get(class1));
                    if (!isValid) return isValid;
                }
                if (Objects.nonNull(requestParamFound.get(field.getName()))) {
                    String str = (String) field.get(class1);
                    isValid = isValid && str.toLowerCase().contains(requestParamFound.get(field.getName()).toLowerCase());
                    if (!isValid) return isValid;
                }
            }
        } catch (IllegalAccessException e) {
            return false;
        }
        return isValid;
    }

}


