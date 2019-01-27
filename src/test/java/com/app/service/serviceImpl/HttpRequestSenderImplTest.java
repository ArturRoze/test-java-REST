package com.app.service.serviceImpl;

import okhttp3.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.io.IOException;

import static okhttp3.ResponseBody.create;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class HttpRequestSenderImplTest {

    @InjectMocks
    HttpRequestSenderImpl httpRequestSender;

    @MockBean
    OkHttpClient httpClient = mock(OkHttpClient.class);

    @Mock
    Call call;

    @Test
    public void send() throws IOException {
        //arrange
        String url = "https://test.com/";
        String body = "{\"data\":[{\"id\":\"some_id\"}]}";
        Request request = getRequest(url);
        ResponseBody responseBody = create(MediaType.parse("application/json"), body);
        Response expectedResponse = new Response.Builder()
                .request(request)
                .body(responseBody)
                .code(200)
                .message("Success")
                .protocol(Protocol.HTTP_1_1)
                .build();

        when(httpClient.newCall(any(Request.class))).thenReturn(call);
        when(call.execute()).thenReturn(expectedResponse);

        //action
        String actualResponse = httpRequestSender.send(url);

        //assert
        assertNotNull(expectedResponse.body());
        assertEquals(body, actualResponse);

        //request verify
        ArgumentCaptor<Request> argument = ArgumentCaptor.forClass(Request.class);
        verify(httpClient).newCall(argument.capture());
        Request value = argument.getValue();
        assertEquals(url, value.url().toString());
        assertEquals("application/json", value.headers().get("Content-Type"));
    }

    private Request getRequest(String url) {
        return new Request.Builder().url(url).addHeader("Content-Type", "application/json").build();
    }
}