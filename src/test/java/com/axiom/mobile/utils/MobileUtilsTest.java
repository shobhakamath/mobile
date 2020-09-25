package com.axiom.mobile.utils;

import com.axiom.mobile.entities.Brand;
import com.axiom.mobile.test.util.LoadUtils;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.*;

public class MobileUtilsTest {
    //@Test
    public void test1() {
        Brand[] brands = new LoadUtils().getMobiles();
        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("resolution", "448");
        List<Brand> result = MobileUtils.filterCriteria(brands, requestParams);
        Assert.assertTrue(result.size()==2);
    }

    //@Test
    public void test2() {
        Brand[] brands = new LoadUtils().getMobiles();
        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("audioJack", "Yes");
        List<Brand>  result = MobileUtils.filterCriteria(brands, requestParams);
        Assert.assertTrue(result.size()==36);
    }
}
