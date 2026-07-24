package com.cine.microservicios.usuariosservice.infrastructure.controller;

import com.cine.microservicios.usuariosservice.application.dto.request.CreateUserRequest;
import com.cine.microservicios.usuariosservice.application.usecase.*;
import com.cine.microservicios.usuariosservice.domain.model.Usuario;
import com.cine.microservicios.usuariosservice.infrastructure.mapper.UsuarioMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final CreateUserUseCase createUserUseCase;
    private final GetUserByIdUseCase getUserByIdUseCase;
    private final GetUserByUsernameUseCase getUserByUsernameUseCase;
    private final ListUserUseCase listUserUseCase;
    private final UpdateUserUseCase updateUserUseCase;
    private final DeactivateUserUseCase deactivateUserUseCase;
    private final UsuarioMapper usuarioMapper;

    public UsuarioController(CreateUserUseCase createUserUseCase,
                            GetUserByIdUseCase getUserByIdUseCase,
                            GetUserByUsernameUseCase getUserByUsernameUseCase,
                            ListUserUseCase listUserUseCase,
                            UpdateUserUseCase updateUserUseCase,
                            DeactivateUserUseCase deactivateUserUseCase,
                            UsuarioMapper usuarioMapper) {
        this.createUserUseCase = createUserUseCase;
        this.getUserByIdUseCase = getUserByIdUseCase;
        this.getUserByUsernameUseCase = getUserByUsernameUseCase;
        this.listUserUseCase = listUserUseCase;
        this.updateUserUseCase = updateUserUseCase;
        this.deactivateUserUseCase = deactivateUserUseCase;
        this.usuarioMapper = usuarioMapper;
    }

    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody CreateUserRequest request) {
        Usuario usuario = createUserUseCase.execute(new Usuario());
        usuario.setUsername(request.getUsername());
        usuario.setEmail(request.getEmail());
        usuario.setPassword(request.getPassword());
        return ResponseEntity.ok(usuarioMapper.toResponse(createUserUseCase.execute(usuario)));
    }

    @GetMapping
    public ResponseEntity<List<?>> list() {
        return ResponseEntity.ok(listUserUseCase.execute().stream().map(usuarioMapper::toResponse).toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return getUserByIdUseCase.execute(id)
                .map(usuarioMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<?> getByUsername(@PathVariable String username) {
        return getUserByUsernameUseCase.execute(username)
                .map(usuarioMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Usuario usuario) {
        return updateUserUseCase.execute(id, usuario)
                .map(usuarioMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}/deactivate")
    public ResponseEntity<?> deactivate(@PathVariable Long id) {
        return deactivateUserUseCase.execute(id)
                .map(usuarioMapper::toResponse)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
