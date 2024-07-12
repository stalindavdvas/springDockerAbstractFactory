package com.cap.cursos.controller;

import com.cap.cursos.dto.mongo.Auditoria;
import com.cap.cursos.service.AuditoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auditorias")
public class AuditoriaController {
    @Autowired
    private AuditoriaService auditoriaService;

    @GetMapping
    public List<Auditoria> getAllAuditorias() {
        return auditoriaService.getAllAuditorias();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Auditoria> getAuditoriaById(@PathVariable String id) {
        return auditoriaService.getAuditoriaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Auditoria createAuditoria(@RequestBody Auditoria auditoria) {
        return auditoriaService.createAuditoria(auditoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuditoria(@PathVariable String id) {
        auditoriaService.deleteAuditoria(id);
        return ResponseEntity.ok().build();
    }
}