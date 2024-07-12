package com.cap.cursos.service;

import com.cap.cursos.dto.postgres.Curso;
import com.cap.cursos.factory.DatabaseFactory;
import com.cap.cursos.repository.postgres.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {
    private final CursoRepository cursoRepository;

    @Autowired
    public CursoService(@Qualifier("postgresFactory") DatabaseFactory databaseFactory) {
        this.cursoRepository = (CursoRepository) databaseFactory.createRepository("curso");
    }

    public List<Curso> getAllCursos() {
        return cursoRepository.findAll();
    }

    public Optional<Curso> getCursoById(Long id) {
        return cursoRepository.findById(id);
    }

    public Curso createCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Curso updateCurso(Long id, Curso cursoDetails) {
        Optional<Curso> curso = cursoRepository.findById(id);
        if (curso.isPresent()) {
            Curso existingCurso = curso.get();
            existingCurso.setNombre(cursoDetails.getNombre());
            return cursoRepository.save(existingCurso);
        }
        return null;
    }

    public void deleteCurso(Long id) {
        cursoRepository.deleteById(id);
    }
}