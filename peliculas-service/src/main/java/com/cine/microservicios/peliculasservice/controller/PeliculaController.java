package com.cine.microservicios.peliculasservice.controller;

import com.cine.microservicios.peliculasservice.dto.TmdbResponse;
import com.cine.microservicios.peliculasservice.entity.Pelicula;
import com.cine.microservicios.peliculasservice.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/peliculas")
@CrossOrigin(origins = "*")
public class PeliculaController {

    @Autowired
    private PeliculaService peliculaService;

    @GetMapping
    public ResponseEntity<List<Pelicula>> listarPeliculas() {
        return ResponseEntity.ok(peliculaService.listarPeliculas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pelicula> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(peliculaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Pelicula> guardar(@RequestBody Pelicula pelicula) {
        return new ResponseEntity<>(peliculaService.guardar(pelicula), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pelicula> actualizar(@PathVariable Long id,
                                               @RequestBody Pelicula pelicula) {

        return ResponseEntity.ok(peliculaService.actualizar(id, pelicula));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {

        peliculaService.eliminar(id);

        return ResponseEntity.ok("Película eliminada correctamente");

    }

    @GetMapping("/genero/{genero}")
    public ResponseEntity<List<Pelicula>> buscarGenero(@PathVariable String genero) {

        return ResponseEntity.ok(peliculaService.buscarGenero(genero));

    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<Pelicula>> buscarTitulo(@PathVariable String titulo) {

        return ResponseEntity.ok(peliculaService.buscarTitulo(titulo));

    }

    @GetMapping("/clasificacion/{clasificacion}")
    public ResponseEntity<List<Pelicula>> buscarClasificacion(
            @PathVariable String clasificacion) {

        return ResponseEntity.ok(
                peliculaService.buscarClasificacion(clasificacion));

    }

    @GetMapping("/tmdb")
    public ResponseEntity<TmdbResponse> peliculasTMDB() {

        return ResponseEntity.ok(
                peliculaService.peliculasTMDB());

    }

}
