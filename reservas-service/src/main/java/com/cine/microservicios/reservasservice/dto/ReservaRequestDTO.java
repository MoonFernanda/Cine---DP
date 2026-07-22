package com.cine.microservicios.reservasservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservaRequestDTO {
    @NotNull(message = "El ID del usuario es obligatorio")
    private String usuarioId;

    @NotNull(message = "El ID de la película es obligatorio")
    private String peliculaId;

    @NotNull(message = "El ID de la función es obligatorio")
    private String funcionId;

    @NotEmpty(message = "Debe seleccionar al menos un asiento")
    private List<String> asientos;
}