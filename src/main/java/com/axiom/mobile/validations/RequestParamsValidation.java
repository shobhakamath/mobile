package com.axiom.mobile.validations;

import com.axiom.mobile.entities.Hardware;
import com.axiom.mobile.entities.Release;
import com.axiom.mobile.exception.BadRequestException;
import com.axiom.mobile.utils.MobileUtils;

import java.lang.reflect.Field;
import java.util.*;

import static com.axiom.mobile.utils.MobileUtils.isRelease;


public class RequestParamsValidation {


    public static void validateRequestParamsRecursively(Map<String, Boolean> requestParamFound,
                                                        Class class1) {
        Field[] fields = class1.getDeclaredFields();
        Arrays.stream(fields).forEach(field -> {
                    if (MobileUtils.isHardware.test(field.getType().getSimpleName()))
                        validateRequestParamsRecursively(requestParamFound, Hardware.class);
                    if (isRelease.test(field.getType().getSimpleName()))
                        validateRequestParamsRecursively(requestParamFound, Release.class);
                    if (Objects.nonNull(requestParamFound.get(field.getName()))) {
                        requestParamFound.put(field.getName(), true);
                    }
                }
        );
    }

    public static boolean validateRequestParams(Map<String, Boolean> requestParamFound,
                                                Class class1) {
        validateRequestParamsRecursively(requestParamFound, class1);
        requestParamFound.forEach((k, v) -> System.out.println((k + ":" + v)));
        Set<Boolean> values = new HashSet<Boolean>(requestParamFound.values());
        if (values.size() == 1 && values.contains(true))
            return true;
        else {
            List<String> errorLst = new ArrayList<>();
            requestParamFound.forEach((k, v) -> {
                        if (!v) {
                            errorLst.add(k);
                        }
                    }
            );
            throw new BadRequestException(errorLst,"Validation Errors");
        }
    }



}
