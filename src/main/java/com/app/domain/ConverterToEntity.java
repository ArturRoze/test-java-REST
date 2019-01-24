package com.app.domain;

import com.app.model.DocumentEntity;
import com.app.utils.DateConverterUtil;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class ConverterToEntity {

    public DocumentEntity convertToDocumentEntity(Document document) {
        String hash = document.getHash();
        String description = document.getDescription();
        String language = document.getLanguage();
        String format = document.getFormat();
        String url = document.getUrl();
        String title = document.getTitle();
        String documentOf = document.getDocumentOf();
        String datePublished = document.getDatePublished();
        Timestamp timestampDatePublished = DateConverterUtil.convertStringDateToTimestamp(datePublished);
        String documentType = document.getDocumentType();
        String dateModified = document.getDateModified();
        Timestamp timestampDateModified = DateConverterUtil.convertStringDateToTimestamp(dateModified);
        String relatedItem = document.getRelatedItem();
        String id = document.getId();
        return new DocumentEntity(hash, description, language, format, url, title, documentOf, timestampDatePublished, documentType, timestampDateModified, relatedItem, id);
    }
}
