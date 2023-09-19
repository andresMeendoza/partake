package info1.info2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import info1.info2.entities.Partidos;
import info1.info2.services.PartidosService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/partidos")
public class PartiosController {
    private final PartidosService partidoService;

    @Autowired
    public PartiosController(PartidosService partidoService) {
        this.partidoService = partidoService;
    }

    @GetMapping
    public ResponseEntity<List<Partidos>> obtenerTodosLosPartidos() {
        List<Partidos> partidos = partidoService.obtenerTodosLosPartidos();
        return ResponseEntity.ok(partidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Partidos> obtenerPartidoPorId(@PathVariable Long id) {
        Optional<Partidos> partido = partidoService.obtenerPartidoPorId(id);
        return partido.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @GetMapping
    public ResponseEntity<List<Partidos>> obtenerPartidosPorEquipo(@RequestParam("equipo") String nombreEquipo) {
        List<Partidos> partidos = partidoService.obtenerPartidosPorEquipo(nombreEquipo);
        return ResponseEntity.ok(partidos);
    }
 @GetMapping
public ResponseEntity<List<Partidos>> obtenerPartidosPorFecha(@RequestParam("fecha") String fechaStr) {
    try {
        LocalDate fecha = LocalDate.parse(fechaStr);
        List<Partidos> partidos = partidoService.obtenerPartidosPorFecha(fecha);
        return ResponseEntity.ok(partidos);
    } catch (Exception e) {
        return ResponseEntity.badRequest().body(new ArrayList<>()); 
    }
}
}
