package com.mobile.service;

import com.mobile.config.MobileConfiguration;
import com.mobile.entities.Brand;
import com.mobile.exception.MobileNotFoundException;
import com.mobile.utils.MobileUtils;
import com.mobile.validations.RequestParamsValidation;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class MobileService {


    private MobileConfiguration mobileConfiguration;
    private RestTemplate restTemplate;

    @Autowired
    public MobileService(MobileConfiguration mobileConfiguration, RestTemplate restTemplate) {
        this.mobileConfiguration = mobileConfiguration;
        this.restTemplate = restTemplate;
    }

    public Brand[] getMobiles(Map<String, String> requestParameters) {
        Map<String, Boolean> reqParams = new HashMap<>();
        requestParameters.forEach((k, v) -> reqParams.put(k,false)) ;
        RequestParamsValidation.validateRequestParams(reqParams, Brand.class);
        Brand[] brands = callMobileService(requestParameters);
        List<Brand> brands1 = MobileUtils.filterCriteria(brands, requestParameters);
        return brands1.toArray(new Brand[]);
    }

    @HystrixCommand(fallbackMethod = "fallBackMethod")
    @HystrixProperty(name = "hystrix.command.default.execution.timeout.enabled", value = "false")
    public Brand[] callMobileService(Map<String,String> requestParams) {
        return Objects.requireNonNull(restTemplate.
                getForObject(mobileConfiguration.getMobileUrl(), Brand[].class));

    }

    public Brand[] fallBackMethod(Map<String,String> requestParams) {
         throw new MobileNotFoundException("No mobiles found");
    }
}
