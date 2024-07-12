package com.cap.cursos.service;

import com.cap.cursos.dto.postgres.Usuario;
import com.cap.cursos.factory.DatabaseFactory;
import com.cap.cursos.repository.postgres.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(@Qualifier("postgresFactory") DatabaseFactory databaseFactory) {
        this.usuarioRepository = (UsuarioRepository) databaseFactory.createRepository("usuario");
    }

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> getUsuarioById(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario updateUsuario(Long id, Usuario usuarioDetails) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            Usuario existingUsuario = usuario.get();
            existingUsuario.setNombre(usuarioDetails.getNombre());
            existingUsuario.setApellido(usuarioDetails.getApellido());
            existingUsuario.setDni(usuarioDetails.getDni());
            existingUsuario.setCorreo(usuarioDetails.getCorreo());
            existingUsuario.setCelular(usuarioDetails.getCelular());
            existingUsuario.setRol(usuarioDetails.getRol());
            return usuarioRepository.save(existingUsuario);
        }
        return null;
    }

    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}