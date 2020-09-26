package com.mobile.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MobileConfiguration {

    @Value("${mobile.url}")
    private String mobileUrl;
    @Value("${mobile.connection.timeout}")
    private String mobileConnectionTimeout;
    @Value("${mobile.read.timeout}")
    private String mobileReadTimeout;

    public String getMobileUrl() {
        return mobileUrl;
    }

    public String getMobileConnectionTimeout() {
        return mobileConnectionTimeout;
    }

    public String getMobileReadTimeout() {
        return mobileReadTimeout;
    }
}
