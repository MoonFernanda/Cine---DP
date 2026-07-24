package com.cine.microservicios.usuariosservice.infrastructure.persistence.adapter;

import com.cine.microservicios.usuariosservice.domain.model.Usuario;
import com.cine.microservicios.usuariosservice.domain.ports.UsuarioRepository;
import com.cine.microservicios.usuariosservice.infrastructure.persistence.entity.UsuarioEntity;
import com.cine.microservicios.usuariosservice.infrastructure.persistence.repository.UsuarioJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UsuarioPersistenceAdapter implements UsuarioRepository {
    private final UsuarioJpaRepository repository;

    public UsuarioPersistenceAdapter(UsuarioJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Usuario save(Usuario usuario) {
        UsuarioEntity entity = UsuarioEntity.fromDomain(usuario);
        return repository.save(entity).toDomain();
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return repository.findById(id).map(UsuarioEntity::toDomain);
    }

    @Override
    public Optional<Usuario> findByUsername(String username) {
        return repository.findByUsername(username).map(UsuarioEntity::toDomain);
    }

    @Override
    public List<Usuario> findAll() {
        return repository.findAll().stream().map(UsuarioEntity::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
