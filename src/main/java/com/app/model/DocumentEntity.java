package com.app.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "document")
@Data
@NoArgsConstructor
public class DocumentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDb")
    private Long idDb;

    @Column(name = "hash")
    private String hash;

    @Column(name = "description")
    private String description;

    @Column(name = "language")
    private String language;

    @Column(name = "format")
    private String format;

    @Column(name = "url")
    private String url;

    @Column(name = "title")
    private String title;

    @Column(name = "documentOf")
    private String documentOf;

    @Column(name = "datePublished")
    @Type(type="timestamp")
    private Timestamp datePublished;

    @Column(name = "documentType")
    private String documentType;

    @Column(name = "dateModified")
    @Type(type="timestamp")
    private Timestamp dateModified;

    @Column(name = "relatedItem")
    private String relatedItem;

    @Column(name = "id", unique = true)
    private String id;

    public DocumentEntity(String hash, String description, String language, String format, String url, String title, String documentOf, Timestamp datePublished, String documentType, Timestamp dateModified, String relatedItem, String id) {
        this.hash = hash;
        this.description = description;
        this.language = language;
        this.format = format;
        this.url = url;
        this.title = title;
        this.documentOf = documentOf;
        this.datePublished = datePublished;
        this.documentType = documentType;
        this.dateModified = dateModified;
        this.relatedItem = relatedItem;
        this.id = id;
    }
}
