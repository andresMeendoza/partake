package info1.info2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import info1.info2.dto.PartidosDTO; // Importa los DTO
import info1.info2.entities.Partidos;
import info1.info2.services.PartidosService;
import info1.info2.mappers.PartidosMapper; // Importa el mapper

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/partidos")
public class PartiosController {
    private final PartidosService partidoService;
    private final PartidosMapper partidosMapper; // Inyecta el mapper

    @Autowired
    public PartiosController(PartidosService partidoService, PartidosMapper partidosMapper) {
        this.partidoService = partidoService;
        this.partidosMapper = partidosMapper; // Asigna el mapper
    }

    @GetMapping
    public ResponseEntity<List<PartidosDTO>> obtenerTodosLosPartidos() {
        List<Partidos> partidos = partidoService.obtenerTodosLosPartidos();
        List<PartidosDTO> partidosDTO = partidos.stream()
                .map(partidosMapper::toDTO) // Convierte las entidades en DTO
                .collect(Collectors.toList());
        return ResponseEntity.ok(partidosDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PartidosDTO> obtenerPartidoPorId(@PathVariable Long id) {
        Optional<Partidos> partido = partidoService.obtenerPartidoPorId(id);
        return partido.map(partidosMapper::toDTO) // Convierte la entidad en DTO
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/equipos")
    public ResponseEntity<List<PartidosDTO>> obtenerPartidosPorEquipo(@RequestParam("equipo") String nombreEquipo) {
        List<Partidos> partidos = partidoService.obtenerPartidosPorEquipo(nombreEquipo);
        List<PartidosDTO> partidosDTO = partidos.stream()
                .map(partidosMapper::toDTO) // Convierte las entidades en DTO
                .collect(Collectors.toList());
        return ResponseEntity.ok(partidosDTO);
    }

    @GetMapping("/fecha")
    public ResponseEntity<List<PartidosDTO>> obtenerPartidosPorFecha(@RequestParam("fecha") LocalDate fecha) {
        try {
            List<Partidos> partidos = partidoService.obtenerPartidosPorFecha(fecha);
            List<PartidosDTO> partidosDTO = partidos.stream()
                    .map(partidosMapper::toDTO) // Convierte las entidades en DTO
                    .collect(Collectors.toList());

            if (partidosDTO.isEmpty())
                return ResponseEntity.notFound().build();

            return ResponseEntity.ok(partidosDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }
}

