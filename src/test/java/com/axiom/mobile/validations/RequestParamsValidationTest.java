package com.axiom.mobile.validations;

import com.axiom.mobile.entities.Brand;
import com.axiom.mobile.exception.BadRequestException;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class RequestParamsValidationTest {
    @Test
    public void testRequestParams() {
        Map<String, Boolean> requestParams = new HashMap<>();
        requestParams.put("resolution", false);
        Assert.assertTrue(RequestParamsValidation.validateRequestParams(requestParams, Brand.class));
    }

    @Test
    public void testRequestParamsException() {
        Map<String, Boolean> requestParams = new HashMap<>();
        requestParams.put("resolution1", false);
        Assertions.assertThrows(BadRequestException.class, ()->
                RequestParamsValidation.validateRequestParams(requestParams, Brand.class));
    }
}
