package com.cine.microservicios.usuariosservice.application.usecase;

import com.cine.microservicios.usuariosservice.domain.enums.EstadoUsuario;
import com.cine.microservicios.usuariosservice.domain.model.Usuario;
import com.cine.microservicios.usuariosservice.domain.ports.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeactivateUserUseCase {
    private final UsuarioRepository usuarioRepository;

    public DeactivateUserUseCase(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Optional<Usuario> execute(Long id) {
        return usuarioRepository.findById(id).map(existing -> {
            existing.setEstado(EstadoUsuario.INACTIVO);
            return usuarioRepository.save(existing);
        });
    }
}
