package com.cine.microservicios.usuariosservice.infrastructure.persistence.entity;

import com.cine.microservicios.usuariosservice.domain.enums.EstadoUsuario;
import com.cine.microservicios.usuariosservice.domain.enums.Rol;
import com.cine.microservicios.usuariosservice.domain.model.Usuario;
import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    @Enumerated(EnumType.STRING)
    private EstadoUsuario estado;

    public UsuarioEntity() {
    }

    public Usuario toDomain() {
        return new Usuario(id, username, email, password, rol, estado);
    }

    public static UsuarioEntity fromDomain(Usuario usuario) {
        UsuarioEntity entity = new UsuarioEntity();
        entity.id = usuario.getId();
        entity.username = usuario.getUsername();
        entity.email = usuario.getEmail();
        entity.password = usuario.getPassword();
        entity.rol = usuario.getRol();
        entity.estado = usuario.getEstado();
        return entity;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public Rol getRol() { return rol; }
    public void setRol(Rol rol) { this.rol = rol; }
    public EstadoUsuario getEstado() { return estado; }
    public void setEstado(EstadoUsuario estado) { this.estado = estado; }
}
