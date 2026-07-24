package com.cine.microservicios.usuariosservice.infrastructure.mapper;

import com.cine.microservicios.usuariosservice.application.dto.responses.UserResponse;
import com.cine.microservicios.usuariosservice.domain.model.Usuario;

public class UsuarioMapper {
    public UserResponse toResponse(Usuario usuario) {
        return new UserResponse(usuario.getId(), usuario.getUsername(), usuario.getEmail(), usuario.getEstado().name());
    }
}
