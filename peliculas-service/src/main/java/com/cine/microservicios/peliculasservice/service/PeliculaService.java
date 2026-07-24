package com.cine.microservicios.peliculasservice.service;

import com.cine.microservicios.peliculasservice.client.TmdbClient;
import com.cine.microservicios.peliculasservice.dto.TmdbResponse;
import com.cine.microservicios.peliculasservice.entity.Pelicula;
import com.cine.microservicios.peliculasservice.exception.ResourceNotFoundException;
import com.cine.microservicios.peliculasservice.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaService {

    @Autowired
    private PeliculaRepository repository;

    @Autowired
    private TmdbClient tmdbClient;

    public List<Pelicula> listarPeliculas() {

        return repository.findAll();

    }

    public Pelicula buscarPorId(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Película no encontrada"));

    }

    public Pelicula guardar(Pelicula pelicula) {

        return repository.save(pelicula);

    }

    public Pelicula actualizar(Long id, Pelicula pelicula) {

        Pelicula existente = buscarPorId(id);

        existente.setTitulo(pelicula.getTitulo());
        existente.setDescripcion(pelicula.getDescripcion());
        existente.setGenero(pelicula.getGenero());
        existente.setDuracion(pelicula.getDuracion());
        existente.setFechaEstreno(pelicula.getFechaEstreno());
        existente.setClasificacion(pelicula.getClasificacion());
        existente.setImagen(pelicula.getImagen());

        return repository.save(existente);

    }

    public void eliminar(Long id) {

        repository.delete(buscarPorId(id));

    }

    public List<Pelicula> buscarGenero(String genero) {

        return repository.findByGenero(genero);

    }

    public List<Pelicula> buscarTitulo(String titulo) {

        return repository.findByTituloContainingIgnoreCase(titulo);

    }

    public List<Pelicula> buscarClasificacion(String clasificacion) {

        return repository.findByClasificacion(clasificacion);

    }

    public TmdbResponse peliculasTMDB() {

        return tmdbClient.obtenerPeliculas();

    }

}
