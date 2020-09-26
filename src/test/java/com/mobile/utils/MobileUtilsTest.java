package com.mobile.utils;

import com.mobile.entities.Brand;
import com.mobile.test.util.LoadUtils;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.*;

public class MobileUtilsTest {
    @Test
    public void testSingleValidParams() {
        Brand[] brands = new LoadUtils().getMobiles();
        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("resolution", "448");
        List<Brand> result = MobileUtils.filterCriteria(brands, requestParams);
        Assert.assertTrue(result.size()==2);
    }

    @Test
    public void testMultipleRequestParams() {
        Brand[] brands = new LoadUtils().getMobiles();
        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("audioJack", "Yes");
        requestParams.put("sim", "esim");
        List<Brand>  result = MobileUtils.filterCriteria(brands, requestParams);
        Assert.assertTrue(result.size()==9);
    }
    @Test
    public void testMultipleRequestParamValues() {
        Brand[] brands = new LoadUtils().getMobiles();
        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("audioJack", "Yes");
        requestParams.put("priceEur","200");
        List<Brand>  result = MobileUtils.filterCriteria(brands, requestParams);
        Assert.assertTrue(result.size()==4);
    }
}
