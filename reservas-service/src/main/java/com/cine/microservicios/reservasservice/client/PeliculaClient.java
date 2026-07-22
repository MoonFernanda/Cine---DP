package com.cine.microservicios.reservasservice.client;

import com.cine.microservicios.reservasservice.dto.PeliculaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "peliculas-service", url = "http://localhost:8081")
public interface PeliculaClient {

    @GetMapping("/api/peliculas/{id}")
    PeliculaDTO getPeliculaById(@PathVariable("id") String id);
}