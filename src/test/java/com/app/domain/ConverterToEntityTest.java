package com.app.domain;

import com.app.model.DocumentEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.Instant;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ConverterToEntityTest {

    @Test
    public void convertToDocumentEntity() {

        //arrange
        Document document = getDummyDocument();
        ConverterToEntity converterToEntity = new ConverterToEntity();

        //action
        DocumentEntity documentEntity = converterToEntity.convertToDocumentEntity(document);

        //assert
        assertEquals(document.getHash(), documentEntity.getHash());
        assertEquals(document.getDescription(), documentEntity.getDescription());
        assertEquals(document.getFormat(), documentEntity.getFormat());
        assertEquals(document.getUrl(), documentEntity.getUrl());
        assertEquals(document.getTitle(), documentEntity.getTitle());
        assertEquals(document.getDocumentOf(), documentEntity.getDocumentOf());
        assertEquals(DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse(document.getDatePublished(), Instant::from), documentEntity.getDatePublished().toInstant());
        assertEquals(document.getDocumentType(), documentEntity.getDocumentType());
        assertEquals(DateTimeFormatter.ISO_OFFSET_DATE_TIME.parse(document.getDateModified(), Instant::from), documentEntity.getDateModified().toInstant());
        assertEquals(document.getRelatedItem(), documentEntity.getRelatedItem());
        assertEquals(document.getLanguage(), documentEntity.getLanguage());
        assertEquals(document.getId(), documentEntity.getId());
    }

    private Document getDummyDocument() {
        String hash = "@hash";
        String description = "test";
        String format = "pdf";
        String url = "http://test.com";
        String title = "test";
        String documentOf = "test";
        String datePublished = "2018-09-19T13:12:21.136263+03:00";
        String documentType = "xls";
        String dateModified = "2018-09-19T13:12:21.136363+03:00";
        String relatedItem = "test";
        String language = "uk";
        String id = "unique";
        return new Document(hash, description, format, url, title, documentOf, datePublished, documentType, dateModified, relatedItem, language, id);
    }
}