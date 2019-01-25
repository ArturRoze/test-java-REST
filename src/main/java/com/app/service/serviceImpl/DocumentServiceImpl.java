package com.app.service.serviceImpl;

import com.app.domain.ConverterToEntity;
import com.app.domain.Document;
import com.app.domain.IncomeData;
import com.app.domain.RequestUrl;
import com.app.model.DocumentEntity;
import com.app.repository.DocumentRepository;
import com.app.service.DocumentService;
import com.app.service.RequestSender;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
public class DocumentServiceImpl implements DocumentService {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    private final DocumentRepository documentRepository;
    private final ConverterToEntity converterToEntity;
    private final RequestSender requestSender;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public DocumentServiceImpl(DocumentRepository documentRepository, ConverterToEntity converterToEntity, RequestSender requestSender) {
        this.documentRepository = documentRepository;
        this.converterToEntity = converterToEntity;
        this.requestSender = requestSender;
    }

    @Override
    @Transactional
    public void saveDocument(RequestUrl url) {
        IncomeData incomeData = sendRequest(url);
        if (incomeData != null) {
            incomeData.getData().forEach(this::save);
        }
    }


    public IncomeData sendRequest(RequestUrl url) {
        String response = requestSender.send(url.getUrl());

        LOGGER.info("response: {}", response);
        try {
            return objectMapper.readValue(response, IncomeData.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void save(Document document) {
        DocumentEntity documentEntity = converterToEntity.convertToDocumentEntity(document);
        String id = document.getId();
        DocumentEntity documentFromDb = documentRepository.getById(id);
        if (documentFromDb != null) {
            documentEntity.setIdDb(documentFromDb.getIdDb());
        }
        documentRepository.save(documentEntity);
    }
}
