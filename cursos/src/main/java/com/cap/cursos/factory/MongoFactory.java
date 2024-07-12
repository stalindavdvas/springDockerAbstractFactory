package com.cap.cursos.factory;

import com.cap.cursos.repository.mongo.AuditoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MongoFactory implements DatabaseFactory {
    @Autowired
    private AuditoriaRepository auditoriaRepository;

    @Override
    public Object createRepository(String type) {
        if ("auditoria".equals(type)) {
            return auditoriaRepository;
        }
        throw new IllegalArgumentException("Tipo de repositorio no válido");
    }
}