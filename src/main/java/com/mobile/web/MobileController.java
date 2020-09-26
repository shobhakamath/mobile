package com.mobile.web;

import com.mobile.entities.Brand;
import com.mobile.exception.ConfigurationException;
import com.mobile.service.MobileService;
import com.mobile.utils.MobileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * MobileController
 *
 * @author shobha
 * @version 1.0
 */
@EnableCircuitBreaker
@RestController
@RequestMapping("/mobile")
public class MobileController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MobileController.class);
    /**
     * The mobile service used to fetch records from 3rd party API
     */

    @Autowired
    MobileService mobileService;

    /**
     * Check if all the configuration parameters are properly initialized.
     *
     * @throws ConfigurationException if mobileService is not properly initialized.
     */
    @PostConstruct
    public void init() {
        MobileUtils.checkNull(mobileService, "mobileHandler");
    }

    /**
     * Handles the create  Http request.
     *
     * @param allParams
     *
     * @return REST API for searching mobiles
     */
    @GetMapping(value = "/search")
    @ResponseStatus(HttpStatus.OK)
    public Brand[] searchMobiles(@RequestParam Map<String, String> allParams) {
        LOGGER.info("searchMobiles");
        return mobileService.getMobiles(allParams);
    }

}