package com.cine.microservicios.reservasservice.service.impl;

import com.cine.microservicios.reservasservice.client.PeliculaClient;
import com.cine.microservicios.reservasservice.dto.PeliculaDTO;
import com.cine.microservicios.reservasservice.dto.ReservaRequestDTO;
import com.cine.microservicios.reservasservice.dto.ReservaResponseDTO;
import com.cine.microservicios.reservasservice.entity.Reserva;
import com.cine.microservicios.reservasservice.exception.ResourceNotFoundException;
import com.cine.microservicios.reservasservice.repository.ReservaRepository;
import com.cine.microservicios.reservasservice.service.interfaces.IReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservaServiceImpl implements IReservaService {

    private final ReservaRepository reservaRepository;
    private final PeliculaClient peliculaClient;

    @Override
    public ReservaResponseDTO crearReserva(ReservaRequestDTO request) {
        // Validar que la película existe
        PeliculaDTO pelicula = peliculaClient.getPeliculaById(request.getPeliculaId());

        Reserva reserva = new Reserva();
        reserva.setUsuarioId(request.getUsuarioId());
        reserva.setPeliculaId(request.getPeliculaId());
        reserva.setFuncionId(request.getFuncionId());
        reserva.setAsientos(request.getAsientos());
        reserva.setPrecioTotal(pelicula.getPrecio() * request.getAsientos().size());
        reserva.setEstado("PENDIENTE");
        reserva.setFechaReserva(LocalDateTime.now());
        reserva.setFechaFuncion(LocalDateTime.now().plusDays(1)); // Simulación
        reserva.setCodigoConfirmacion(generarCodigoConfirmacion());

        Reserva reservaGuardada = reservaRepository.save(reserva);
        return convertirAResponseDTO(reservaGuardada, pelicula);
    }

    @Override
    public ReservaResponseDTO obtenerReserva(String id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reserva no encontrada con ID: " + id));

        PeliculaDTO pelicula = peliculaClient.getPeliculaById(reserva.getPeliculaId());
        return convertirAResponseDTO(reserva, pelicula);
    }

    @Override
    public List<ReservaResponseDTO> obtenerReservasPorUsuario(String usuarioId) {
        List<Reserva> reservas = reservaRepository.findByUsuarioId(usuarioId);
        return reservas.stream()
                .map(reserva -> {
                    PeliculaDTO pelicula = peliculaClient.getPeliculaById(reserva.getPeliculaId());
                    return convertirAResponseDTO(reserva, pelicula);
                })
                .collect(Collectors.toList());
    }

    @Override
    public ReservaResponseDTO confirmarReserva(String id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reserva no encontrada con ID: " + id));

        reserva.setEstado("CONFIRMADA");
        Reserva reservaActualizada = reservaRepository.save(reserva);

        PeliculaDTO pelicula = peliculaClient.getPeliculaById(reserva.getPeliculaId());
        return convertirAResponseDTO(reservaActualizada, pelicula);
    }

    @Override
    public ReservaResponseDTO cancelarReserva(String id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reserva no encontrada con ID: " + id));

        reserva.setEstado("CANCELADA");
        Reserva reservaActualizada = reservaRepository.save(reserva);

        PeliculaDTO pelicula = peliculaClient.getPeliculaById(reserva.getPeliculaId());
        return convertirAResponseDTO(reservaActualizada, pelicula);
    }

    @Override
    public List<ReservaResponseDTO> obtenerTodasReservas() {
        List<Reserva> reservas = reservaRepository.findAll();
        return reservas.stream()
                .map(reserva -> {
                    try {
                        PeliculaDTO pelicula = peliculaClient.getPeliculaById(reserva.getPeliculaId());
                        return convertirAResponseDTO(reserva, pelicula);
                    } catch (Exception e) {
                        return convertirAResponseDTO(reserva, null);
                    }
                })
                .collect(Collectors.toList());
    }

    private String generarCodigoConfirmacion() {
        return "RES-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    private ReservaResponseDTO convertirAResponseDTO(Reserva reserva, PeliculaDTO pelicula) {
        ReservaResponseDTO response = new ReservaResponseDTO();
        response.setId(reserva.getId());
        response.setUsuarioId(reserva.getUsuarioId());
        response.setPeliculaId(reserva.getPeliculaId());
        if (pelicula != null) {
            response.setPeliculaTitulo(pelicula.getTitulo());
        }
        response.setFuncionId(reserva.getFuncionId());
        response.setAsientos(reserva.getAsientos());
        response.setPrecioTotal(reserva.getPrecioTotal());
        response.setEstado(reserva.getEstado());
        response.setFechaReserva(reserva.getFechaReserva());
        response.setFechaFuncion(reserva.getFechaFuncion());
        response.setCodigoConfirmacion(reserva.getCodigoConfirmacion());
        return response;
    }
}