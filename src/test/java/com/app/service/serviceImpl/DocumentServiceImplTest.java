package com.app.service.serviceImpl;

import com.app.domain.ConverterToEntity;
import com.app.domain.IncomeData;
import com.app.repository.DocumentRepository;
import com.app.service.RequestSender;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.OkHttpClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class DocumentServiceImplTest {

    @InjectMocks
    private DocumentServiceImpl documentServiceImpl;

    @Mock
    private DocumentRepository documentRepository;

    @Mock
    private ConverterToEntity converterToEntity;

    @InjectMocks
    private RequestSender requestSender;

    @Mock
    private OkHttpClient httpClient;

    @Mock
    private ObjectMapper objectMapper;

    @Test
    public void saveDocument() {

        //arrange


        //action


        //assert


    }

    @Test
    void sendRequest() {

        //arrange
        String stringJson = "{\"data\":[{\"id\":\"some_id\"}]}";

        when(requestSender.send(any())).thenReturn(stringJson);

        //action
        IncomeData incomeData = documentServiceImpl.sendRequest(any());

        //assert
        assertEquals("some_id", incomeData.getData().get(0).getId());

    }
}