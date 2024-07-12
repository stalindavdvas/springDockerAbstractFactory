package com.cap.cursos.repository.postgres;

import com.cap.cursos.dto.postgres.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

public interface NotaRepository extends JpaRepository<Nota, Long> {
}