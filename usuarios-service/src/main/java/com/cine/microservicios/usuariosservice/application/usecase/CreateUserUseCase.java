package com.cine.microservicios.usuariosservice.application.usecase;

import com.cine.microservicios.usuariosservice.domain.enums.EstadoUsuario;
import com.cine.microservicios.usuariosservice.domain.enums.Rol;
import com.cine.microservicios.usuariosservice.domain.model.Usuario;
import com.cine.microservicios.usuariosservice.domain.ports.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUseCase {
    private final UsuarioRepository usuarioRepository;

    public CreateUserUseCase(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario create(String username, String email, String password) {
        Usuario usuario = new Usuario();
        usuario.setUsername(username);
        usuario.setEmail(email);
        usuario.setPassword(password);
        usuario.setEstado(EstadoUsuario.ACTIVO);
        usuario.setRol(Rol.USER);
        return usuarioRepository.save(usuario);
    }

    public Usuario execute(Usuario usuario) {
        usuario.setEstado(EstadoUsuario.ACTIVO);
        usuario.setRol(Rol.USER);
        return usuarioRepository.save(usuario);
    }
}
