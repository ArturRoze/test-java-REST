package com.app.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
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
