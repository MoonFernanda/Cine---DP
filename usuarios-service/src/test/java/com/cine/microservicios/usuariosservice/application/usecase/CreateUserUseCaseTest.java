package com.cine.microservicios.usuariosservice.application.usecase;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import com.cine.microservicios.usuariosservice.domain.enums.EstadoUsuario;
import com.cine.microservicios.usuariosservice.domain.enums.Rol;
import com.cine.microservicios.usuariosservice.domain.model.Usuario;
import com.cine.microservicios.usuariosservice.domain.ports.UsuarioRepository;
import org.junit.jupiter.api.Test;

class CreateUserUseCaseTest {

    @Test
    void shouldCreateUserWithDefaultActiveState() {
        UsuarioRepository repository = mock(UsuarioRepository.class);
        Usuario usuarioEsperado = new Usuario();
        usuarioEsperado.setUsername("juan");
        usuarioEsperado.setEmail("juan@mail.com");
        usuarioEsperado.setPassword("Password123");
        usuarioEsperado.setEstado(EstadoUsuario.ACTIVO);
        usuarioEsperado.setRol(Rol.USER);

        when(repository.save(any(Usuario.class))).thenReturn(usuarioEsperado);

        CreateUserUseCase createUserUseCase = new CreateUserUseCase(repository);
        Usuario usuario = createUserUseCase.create("juan", "juan@mail.com", "Password123");

        assertThat(usuario).isNotNull();
        assertThat(usuario.getUsername()).isEqualTo("juan");
        assertThat(usuario.getEmail()).isEqualTo("juan@mail.com");
        assertThat(usuario.getStatus()).isEqualTo("ACTIVO");
        verify(repository).save(any(Usuario.class));
    }
}
