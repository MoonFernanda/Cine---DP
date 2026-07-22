package com.cine.microservicios.reservasservice.service.interfaces;

import com.cine.microservicios.reservasservice.dto.ReservaRequestDTO;
import com.cine.microservicios.reservasservice.dto.ReservaResponseDTO;

import java.util.List;

public interface IReservaService {
    ReservaResponseDTO crearReserva(ReservaRequestDTO request);
    ReservaResponseDTO obtenerReserva(String id);
    List<ReservaResponseDTO> obtenerReservasPorUsuario(String usuarioId);
    ReservaResponseDTO confirmarReserva(String id);
    ReservaResponseDTO cancelarReserva(String id);
    List<ReservaResponseDTO> obtenerTodasReservas();
}