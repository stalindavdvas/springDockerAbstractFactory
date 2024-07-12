package com.cap.cursos.factory;

import com.cap.cursos.repository.postgres.CursoRepository;
import com.cap.cursos.repository.postgres.NotaRepository;
import com.cap.cursos.repository.postgres.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostgresFactory implements DatabaseFactory {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private NotaRepository notaRepository;

    @Override
    public Object createRepository(String type) {
        switch (type) {
            case "usuario":
                return usuarioRepository;
            case "curso":
                return cursoRepository;
            case "nota":
                return notaRepository;
            default:
                throw new IllegalArgumentException("Tipo de repositorio no válido");
        }
    }
}