package com.mobile.web;

import com.mobile.entities.Brand;
import com.mobile.entities.Hardware;
import com.mobile.entities.Release;
import com.mobile.service.MobileService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MobileControllerIntegrationTest {
    @LocalServerPort
    private int port;
    private static final String MOBILE_URL = "/mobile/search";
    private static final String BRAND_ID = "1234";
    private static final String BRAND_NAME = "Samsung";
    private static final String SIM_TYPE = "microsim";


    @Mock
    private MobileService mobileServiceMock;
    @Mock
    private Brand brandMock;

    @Mock
    private Hardware hardwareMock;

    @Mock
    private Release releaseMock;
    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setupReturnValuesOfMockMethods() {
        MockitoAnnotations.initMocks(this);
        when(brandMock.getRelease()).thenReturn(releaseMock);
        when(brandMock.getHardware()).thenReturn(hardwareMock);
        when(hardwareMock.getAudioJack()).thenReturn("yes");
        when(releaseMock.getPriceEur()).thenReturn("200");
        when(brandMock.getId()).thenReturn(BRAND_ID);
        when(brandMock.getBrand()).thenReturn(BRAND_NAME);
        when(brandMock.getSim()).thenReturn(SIM_TYPE);
        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.TEXT_HTML));
        restTemplate.getRestTemplate().getMessageConverters().add(mappingJackson2HttpMessageConverter);
    }

    /**
     * HTTP GET /ratings
     */
    @Test
    public void getMobiles() {
        when(mobileServiceMock.getMobiles(anyMap()))
                .thenReturn( new Brand[]{brandMock, brandMock});
        ResponseEntity<Brand[]> response = restTemplate.getForEntity( MOBILE_URL + "?announceDate=1999",
                Brand[].class);

        Assert.assertEquals(response.getStatusCode(), HttpStatus.OK);

    }


}
