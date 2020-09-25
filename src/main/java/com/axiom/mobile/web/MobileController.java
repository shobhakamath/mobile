package com.axiom.mobile.web;

import com.axiom.mobile.entities.Brand;
import com.axiom.mobile.exception.ConfigurationException;
import com.axiom.mobile.service.MobileService;
import com.axiom.mobile.utils.MobileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

@EnableCircuitBreaker
@RestController
@RequestMapping("/mobile")
public class MobileController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MobileController.class);
    /**
     * The user service used to manage user entity in the backend.
     * It is inject by Spring.
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
     * Handles the create user Http request.
     *
     * @param allParams The UserRequest instance which holds the handle of the user to create.
     * @return The created User instance.
     */
    @GetMapping(value="/search")
    @ResponseStatus(HttpStatus.OK)
    public Brand[] searchMobiles(@RequestParam Map<String,String> allParams) {
        LOGGER.info("searchMobiles");
       return mobileService.getMobiles(allParams);
    }

}