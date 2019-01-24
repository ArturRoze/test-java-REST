package com.app.service.serviceImpl;

import com.app.domain.ConverterToEntity;
import com.app.repository.DocumentRepository;
import com.app.service.RequestSender;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)
public class DocumentServiceImplTest {

    @Before
    public static void beforeClass() {
        initMocks(DocumentServiceImpl.class);
    }

    @Mock
    private DocumentRepository documentRepository;

    @Mock
    private ConverterToEntity converterToEntity;

    @InjectMocks
    private RequestSender requestSender;

    @Mock
    private ObjectMapper objectMapper;

    @Test
    public void saveDocument() {

        //arrange



        //action



        //assert



    }
}