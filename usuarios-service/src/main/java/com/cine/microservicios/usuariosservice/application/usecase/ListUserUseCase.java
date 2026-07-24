package com.cine.microservicios.usuariosservice.application.usecase;

import com.cine.microservicios.usuariosservice.domain.model.Usuario;
import com.cine.microservicios.usuariosservice.domain.ports.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListUserUseCase {
    private final UsuarioRepository usuarioRepository;

    public ListUserUseCase(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> execute() {
        return usuarioRepository.findAll();
    }
}
