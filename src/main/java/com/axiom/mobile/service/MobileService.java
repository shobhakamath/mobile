package com.axiom.mobile.service;

import com.axiom.mobile.entities.Brand;
import com.axiom.mobile.exception.MobileNotFoundException;
import com.axiom.mobile.utils.MobileUtils;
import com.axiom.mobile.validations.RequestParamsValidation;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class MobileService {

    @Value("${mobile.url}")
    private String mobileUrl;
    @Autowired
    private RestTemplate restTemplate;

    public Brand[] getMobiles(Map<String, String> requestParameters) {
        Map<String, Boolean> reqParams = new HashMap<>();
        requestParameters.forEach((k, v) -> reqParams.put(k,false)) ;
        RequestParamsValidation.validateRequestParams(reqParams, Brand.class);
        Brand[] brands = callMobileService(requestParameters);
        List<Brand> brands1 = MobileUtils.filterCriteria(brands, requestParameters);
        return brands1.toArray(new Brand[brands1.size()]);
    }

    @HystrixCommand(fallbackMethod = "fallBackMethod")
    @HystrixProperty(name = "hystrix.command.default.execution.timeout.enabled", value = "false")
    public Brand[] callMobileService(Map<String,String> requestParams) {
        return Objects.requireNonNull(restTemplate.
                getForObject(mobileUrl, Brand[].class));

    }

    public Brand[] fallBackMethod(Map<String,String> requestParams) {
         throw new MobileNotFoundException("No mobiles found");
    }
}
