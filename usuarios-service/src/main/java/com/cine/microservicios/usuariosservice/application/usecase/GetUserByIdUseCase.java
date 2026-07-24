package com.cine.microservicios.usuariosservice.application.usecase;

import com.cine.microservicios.usuariosservice.domain.model.Usuario;
import com.cine.microservicios.usuariosservice.domain.ports.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetUserByIdUseCase {
    private final UsuarioRepository usuarioRepository;

    public GetUserByIdUseCase(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Optional<Usuario> execute(Long id) {
        return usuarioRepository.findById(id);
    }
}
