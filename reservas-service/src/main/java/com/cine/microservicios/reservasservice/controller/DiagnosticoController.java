package com.cine.microservicios.reservasservice.controller;

import com.cine.microservicios.reservasservice.entity.Reserva;
import com.cine.microservicios.reservasservice.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/diagnostico")
public class DiagnosticoController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private ReservaRepository reservaRepository;

    @GetMapping("/mongo-status")
    public Map<String, Object> checkMongoStatus() {
        Map<String, Object> response = new HashMap<>();
        try {
            // Verificar conexión
            String dbName = mongoTemplate.getDb().getName();
            response.put("connected", true);
            response.put("database", dbName);

            // Listar colecciones
            List<String> collections = mongoTemplate.getDb()
                    .listCollectionNames()
                    .into(new java.util.ArrayList<>());
            response.put("collections", collections);

            // Contar documentos en reservas
            long count = mongoTemplate.getCollection("reservas").countDocuments();
            response.put("totalDocumentos", count);

        } catch (Exception e) {
            response.put("connected", false);
            response.put("error", e.getMessage());
            response.put("stackTrace", e.getStackTrace());
        }
        return response;
    }

    @GetMapping("/all-reservas")
    public Map<String, Object> getAllReservas() {
        Map<String, Object> response = new HashMap<>();
        try {
            List<Reserva> reservas = reservaRepository.findAll();
            response.put("total", reservas.size());
            response.put("reservas", reservas);
        } catch (Exception e) {
            response.put("error", e.getMessage());
        }
        return response;
    }
}