package com.cap.cursos.repository.postgres;

import com.cap.cursos.dto.postgres.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}