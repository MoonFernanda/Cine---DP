package com.cine.microservicios.reservasservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "reservas")
public class Reserva {
    @Id
    private String id;
    private String usuarioId;
    private String peliculaId;
    private String funcionId;
    private List<String> asientos;
    private Double precioTotal;
    private String estado;
    private LocalDateTime fechaReserva;
    private LocalDateTime fechaFuncion;
    private String codigoConfirmacion;
}