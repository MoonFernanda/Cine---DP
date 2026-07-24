package com.cine.microservicios.usuariosservice.application.dto.responses;

public class UserResponse {
    private Long id;
    private String username;
    private String email;
    private String estado;

    public UserResponse() {
    }

    public UserResponse(Long id, String username, String email, String estado) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
