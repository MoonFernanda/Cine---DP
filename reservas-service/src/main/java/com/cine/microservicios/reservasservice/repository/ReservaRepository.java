package com.cine.microservicios.reservasservice.repository;

import com.cine.microservicios.reservasservice.entity.Reserva;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends MongoRepository<Reserva, String> {
    List<Reserva> findByUsuarioId(String usuarioId);
    List<Reserva> findByPeliculaId(String peliculaId);
    Reserva findByCodigoConfirmacion(String codigoConfirmacion);
}