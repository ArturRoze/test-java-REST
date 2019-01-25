package com.app.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Document {

    private String hash;
    private String description;
    private String format;
    private String url;
    private String title;
    private String documentOf;
    private String datePublished;
    private String documentType;
    private String dateModified;
    private String relatedItem;
    private String language;
    private String id;
}
