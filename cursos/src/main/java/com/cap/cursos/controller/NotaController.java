package com.cap.cursos.controller;

import com.cap.cursos.dto.postgres.Nota;
import com.cap.cursos.service.NotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notas")
public class NotaController {
    @Autowired
    private NotaService notaService;

    @GetMapping
    public List<Nota> getAllNotas() {
        return notaService.getAllNotas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nota> getNotaById(@PathVariable Long id) {
        return notaService.getNotaById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Nota createNota(@RequestBody Nota nota) {
        return notaService.createNota(nota);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Nota> updateNota(@PathVariable Long id, @RequestBody Nota notaDetails) {
        Nota updatedNota = notaService.updateNota(id, notaDetails);
        if (updatedNota == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedNota);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNota(@PathVariable Long id) {
        notaService.deleteNota(id);
        return ResponseEntity.ok().build();
    }
}