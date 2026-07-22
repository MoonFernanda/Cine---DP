package com.cine.microservicios.reservasservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservaResponseDTO {
    private String id;
    private String usuarioId;
    private String peliculaId;
    private String peliculaTitulo;
    private String funcionId;
    private List<String> asientos;
    private Double precioTotal;
    private String estado;
    private LocalDateTime fechaReserva;
    private LocalDateTime fechaFuncion;
    private String codigoConfirmacion;
}