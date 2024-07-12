package com.cap.cursos.repository.postgres;

import com.cap.cursos.dto.postgres.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}