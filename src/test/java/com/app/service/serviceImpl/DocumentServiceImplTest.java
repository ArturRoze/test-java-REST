package com.app.service.serviceImpl;

import com.app.domain.ConverterToEntity;
import com.app.domain.Document;
import com.app.domain.IncomeData;
import com.app.domain.RequestUrl;
import com.app.repository.DocumentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

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
        String url = "https://test.com";
        RequestUrl requestUrl = new RequestUrl(url);
        String stringJson = "{\"data\":[{\"id\":\"some_id\"}]}";
        when(requestSender.send(requestUrl.getUrl())).thenReturn(stringJson);

        //action
        documentServiceImpl.saveDocument(requestUrl);

        //assert
        assertNotNull(stringJson);
        verify(converterToEntity).convertToDocumentEntity(any(Document.class));
        verify(documentRepository).getById("some_id");

    }

    @Test
    public void sendRequest() {
        //arrange
        ObjectMapper objectMapper = new ObjectMapper();
        RequestUrl url = new RequestUrl("http://test.com");
        String stringJson = "{\"data\":[{\"id\":\"some_id\"}]}";
        when(requestSender.send(any(String.class))).thenReturn(stringJson);

        //action
        IncomeData incomeData = documentServiceImpl.sendRequest(url);

        //assert
        assertEquals("some_id", incomeData.getData().get(0).getId());
    }

    @Test
    public void sendRequestFail() {
        //arrange
        RequestUrl url = new RequestUrl("http://test.com");
        when(requestSender.send(any(String.class))).thenReturn("avf");

        //action
        try{
            IncomeData incomeData = documentServiceImpl.sendRequest(url);
        }catch (RuntimeException e){
            return;
        }

        //assert
        fail();
    }
}