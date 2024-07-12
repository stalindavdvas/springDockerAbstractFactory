package com.cap.cursos.service;

import com.cap.cursos.dto.postgres.Nota;
import com.cap.cursos.factory.DatabaseFactory;
import com.cap.cursos.repository.postgres.NotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotaService {
    private final NotaRepository notaRepository;

    @Autowired
    public NotaService(@Qualifier("postgresFactory") DatabaseFactory databaseFactory) {
        this.notaRepository = (NotaRepository) databaseFactory.createRepository("nota");
    }

    public List<Nota> getAllNotas() {
        return notaRepository.findAll();
    }

    public Optional<Nota> getNotaById(Long id) {
        return notaRepository.findById(id);
    }

    public Nota createNota(Nota nota) {
        return notaRepository.save(nota);
    }

    public Nota updateNota(Long id, Nota notaDetails) {
        Optional<Nota> nota = notaRepository.findById(id);
        if (nota.isPresent()) {
            Nota existingNota = nota.get();
            existingNota.setNota(notaDetails.getNota());
            existingNota.setUsuario(notaDetails.getUsuario());
            return notaRepository.save(existingNota);
        }
        return null;
    }

    public void deleteNota(Long id) {
        notaRepository.deleteById(id);
    }
}