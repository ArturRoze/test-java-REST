package com.app.controller;

import com.app.domain.RequestUrl;
import okhttp3.OkHttpClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class RequestControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    OkHttpClient okHttpClient;

    @Test
    public void saveOrUpdate() {

        //arrange
        String url = "https://test.com";
        RequestUrl requestUrl = new RequestUrl(url);

        //action


        //assert


    }
}