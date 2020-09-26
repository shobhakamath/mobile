package com.mobile.service;

import com.mobile.config.MobileConfiguration;
import com.mobile.entities.Brand;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MobileServiceTest {
    @Mock
    MobileConfiguration mobileConfiguration;
    @Mock
    RestTemplate restTemplate;

    @Test
    public void testCallServiceWrongUrl(){
        when(mobileConfiguration.getMobileUrl()).thenReturn("wrong_url");
        Assert.assertNull(restTemplate.getForEntity(mobileConfiguration.getMobileUrl(), Brand[].class));
    }
}
