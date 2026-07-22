package com.cine.microservicios.reservasservice.controller;

import com.cine.microservicios.reservasservice.dto.ReservaRequestDTO;
import com.cine.microservicios.reservasservice.dto.ReservaResponseDTO;
import com.cine.microservicios.reservasservice.service.interfaces.IReservaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/reservas")
@RequiredArgsConstructor
public class ReservaController {

    private final IReservaService reservaService;

    @PostMapping
    public ResponseEntity<ReservaResponseDTO> crearReserva(@Valid @RequestBody ReservaRequestDTO request) {
        return new ResponseEntity<>(reservaService.crearReserva(request), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaResponseDTO> obtenerReserva(@PathVariable String id) {
        return ResponseEntity.ok(reservaService.obtenerReserva(id));
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<ReservaResponseDTO>> obtenerReservasPorUsuario(@PathVariable String usuarioId) {
        return ResponseEntity.ok(reservaService.obtenerReservasPorUsuario(usuarioId));
    }

    @GetMapping
    public ResponseEntity<List<ReservaResponseDTO>> obtenerTodasReservas() {
        return ResponseEntity.ok(reservaService.obtenerTodasReservas());
    }

    @PutMapping("/{id}/confirmar")
    public ResponseEntity<ReservaResponseDTO> confirmarReserva(@PathVariable String id) {
        return ResponseEntity.ok(reservaService.confirmarReserva(id));
    }

    @PutMapping("/{id}/cancelar")
    public ResponseEntity<ReservaResponseDTO> cancelarReserva(@PathVariable String id) {
        return ResponseEntity.ok(reservaService.cancelarReserva(id));
    }
}