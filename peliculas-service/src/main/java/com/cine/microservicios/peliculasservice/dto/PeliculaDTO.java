package com.cine.microservicios.peliculasservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PeliculaDTO {

    private Long id;

    private String titulo;

    private String descripcion;

    private String genero;

    private Integer duracion;

    private LocalDate fechaEstreno;

    private String clasificacion;

    private String imagen;

}
