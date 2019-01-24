package com.app.repository;

import com.app.model.DocumentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface DocumentRepository extends CrudRepository<DocumentEntity, Long> {

    DocumentEntity getById(String id);
}
