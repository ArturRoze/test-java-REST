package com.app.service.serviceImpl;

import com.app.domain.ConverterToEntity;
import com.app.domain.IncomeData;
import com.app.domain.RequestUrl;
import com.app.repository.DocumentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DocumentServiceImplTest {

    @InjectMocks
    private DocumentServiceImpl documentServiceImpl;

    @Mock
    private HttpRequestSenderImpl requestSender;

    @Mock
    private DocumentRepository documentRepository;

    @Mock
    private ConverterToEntity converterToEntity;

    @Test
    public void saveDocument() {

        //arrange


        //action


        //assert


    }

    @Test
    public void sendRequest() {
        //arrange
        RequestUrl url = new RequestUrl("http://test.com");
        String stringJson = "{\"data\":[{\"id\":\"some_id\"}]}";
        when(requestSender.send(any(String.class))).thenReturn(stringJson);

        //action
        IncomeData incomeData = documentServiceImpl.sendRequest(url);

        //assert
        assertEquals("some_id", incomeData.getData().get(0).getId());
    }
}