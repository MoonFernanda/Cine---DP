package com.cine.microservicios.reservasservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeliculaDTO {
    private String id;
    private String titulo;
    private String genero;
    private Integer duracion;
    private String sinopsis;
    private Double precio;
}