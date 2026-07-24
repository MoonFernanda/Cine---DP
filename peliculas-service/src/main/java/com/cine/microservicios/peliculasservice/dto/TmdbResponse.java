package com.cine.microservicios.peliculasservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class TmdbResponse {

    private Integer page;

    private List<TmdbMovie> results;

    private Integer total_pages;

    private Integer total_results;

    @Data
    public static class TmdbMovie {

        private Long id;

        private String title;

        private String overview;

        private String release_date;

        private String poster_path;

        private Double vote_average;

    }

}
