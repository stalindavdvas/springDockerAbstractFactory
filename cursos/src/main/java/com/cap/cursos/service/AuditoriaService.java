package com.cap.cursos.service;

import com.cap.cursos.dto.mongo.Auditoria;
import com.cap.cursos.factory.DatabaseFactory;
import com.cap.cursos.repository.mongo.AuditoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuditoriaService {
    private final AuditoriaRepository auditoriaRepository;

    @Autowired
    public AuditoriaService(@Qualifier("mongoFactory") DatabaseFactory databaseFactory) {
        this.auditoriaRepository = (AuditoriaRepository) databaseFactory.createRepository("auditoria");
    }

    public List<Auditoria> getAllAuditorias() {
        return auditoriaRepository.findAll();
    }

    public Optional<Auditoria> getAuditoriaById(String id) {
        return auditoriaRepository.findById(id);
    }

    public Auditoria createAuditoria(Auditoria auditoria) {
        return auditoriaRepository.save(auditoria);
    }

    public void deleteAuditoria(String id) {
        auditoriaRepository.deleteById(id);
    }
}