package com.app.service.serviceImpl;

import com.app.service.RequestSender;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class HttpRequestSenderImpl implements RequestSender {

    private final OkHttpClient httpClient;

    @Autowired
    public HttpRequestSenderImpl(OkHttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public String send(String url) {
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Content-Type", "application/json")
                .build();

        Call call = httpClient.newCall(request);

        try (Response response = call.execute()) {
            if (response.isSuccessful() && response.body() != null) {
                return response.body().string();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        throw new RuntimeException("Not found " + url);
    }
}
