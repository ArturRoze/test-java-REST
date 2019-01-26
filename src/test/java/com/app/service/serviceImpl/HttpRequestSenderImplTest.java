package com.app.service.serviceImpl;

import okhttp3.*;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.IOException;

import static okhttp3.ResponseBody.create;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HttpRequestSenderImplTest {

    @InjectMocks
    HttpRequestSenderImpl httpRequestSender;

    @MockBean
    OkHttpClient httpClient;

    @Test
    @Ignore
    public void send() throws IOException {

        //arrange
        String url = "https://test.com";
        String body = "{\"data\":[{\"id\":\"some_id\"}]}";
        Request request = getRequest(url);
        ResponseBody responseBody = create(MediaType.parse("application/json"), body);
        Response expectedResponse = new Response.Builder().request(request).body(responseBody).protocol(Protocol.HTTP_1_1).build();
        when(httpClient.newCall(request).execute()).thenReturn(expectedResponse);

        //action
        String actualResponse = httpRequestSender.send(url);

        //assert
        assertNotNull(expectedResponse.body());
        assertEquals(expectedResponse.body().string(), actualResponse);

    }

    private Request getRequest(String url) {
        return new Request.Builder().url(url).addHeader("Content-Type", "application/json").build();
    }
}