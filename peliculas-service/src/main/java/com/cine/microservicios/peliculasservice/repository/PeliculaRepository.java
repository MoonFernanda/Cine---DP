package com.cine.microservicios.peliculasservice.repository;

import com.cine.microservicios.peliculasservice.entity.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {

    List<Pelicula> findByGenero(String genero);

    List<Pelicula> findByTituloContainingIgnoreCase(String titulo);

    List<Pelicula> findByClasificacion(String clasificacion);

}
