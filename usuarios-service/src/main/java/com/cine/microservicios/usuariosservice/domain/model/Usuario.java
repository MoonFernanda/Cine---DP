package com.cine.microservicios.usuariosservice.domain.model;

import com.cine.microservicios.usuariosservice.domain.enums.EstadoUsuario;
import com.cine.microservicios.usuariosservice.domain.enums.Rol;

public class Usuario {
    private Long id;
    private String username;
    private String email;
    private String password;
    private Rol rol;
    private EstadoUsuario estado;

    public Usuario() {
    }

    public Usuario(Long id, String username, String email, String password, Rol rol, EstadoUsuario estado) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.rol = rol;
        this.estado = estado;
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
    public String getStatus() {
        return estado == null ? null : estado.name();
    }
}
