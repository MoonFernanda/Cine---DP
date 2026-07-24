package com.cine.microservicios.peliculasservice.client;

import com.cine.microservicios.peliculasservice.dto.TmdbResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TmdbClient {

    private static final String API_KEY = "TU_API_KEY";

    private static final String URL =
            "https://api.themoviedb.org/3/movie/popular?api_key="
                    + API_KEY
                    + "&language=es-ES&page=1";

    @Autowired
    private RestTemplate restTemplate;

    public TmdbResponse obtenerPeliculas() {

        return restTemplate.getForObject(URL, TmdbResponse.class);

    }

}
