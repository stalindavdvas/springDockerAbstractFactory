package com.cap.cursos.repository.mongo;

import com.cap.cursos.dto.mongo.Auditoria;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuditoriaRepository extends MongoRepository<Auditoria, String> {
}