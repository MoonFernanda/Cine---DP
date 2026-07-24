package com.cine.microservicios.peliculasservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "peliculas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descripcion;

    @Column(nullable = false)
    private String genero;

    @Column(nullable = false)
    private Integer duracion;

    @Column(name = "fecha_estreno")
    private LocalDate fechaEstreno;

    @Column(nullable = false)
    private String clasificacion;

    private String imagen;

}
