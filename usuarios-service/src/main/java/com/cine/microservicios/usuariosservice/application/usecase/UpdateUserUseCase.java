package com.cine.microservicios.usuariosservice.application.usecase;

import com.cine.microservicios.usuariosservice.domain.model.Usuario;
import com.cine.microservicios.usuariosservice.domain.ports.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateUserUseCase {
    private final UsuarioRepository usuarioRepository;

    public UpdateUserUseCase(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Optional<Usuario> execute(Long id, Usuario usuario) {
        return usuarioRepository.findById(id).map(existing -> {
            existing.setUsername(usuario.getUsername());
            existing.setEmail(usuario.getEmail());
            existing.setPassword(usuario.getPassword());
            return usuarioRepository.save(existing);
        });
    }
}
