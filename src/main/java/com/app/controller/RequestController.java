package com.app.controller;

import com.app.domain.RequestUrl;
import com.app.service.DocumentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/documents")
public class RequestController {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    private final DocumentService documentService;

    @Autowired
    public RequestController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping("/save")
    public ResponseEntity<Void> saveOrUpdate(@RequestBody RequestUrl url){
        LOGGER.info("income url: {}", url);
        documentService.saveDocument(url);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
