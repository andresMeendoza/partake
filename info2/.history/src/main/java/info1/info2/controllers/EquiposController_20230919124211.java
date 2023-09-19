package info1.info2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import info1.info2.entities.Equipos;
import info1.info2.services.EquipoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/equipos")
public class EquiposController {
    private final EquipoService equipoService;

    @Autowired
    public EquiposController(EquipoService equipoService) {
        this.equipoService = equipoService;
    }

    @GetMapping
    public ResponseEntity<List<Equipos>> obtenerTodosLosEquipos() {
        List<Equipos> equipos = equipoService.obtenerTodosLosEquipos();
        return ResponseEntity.ok(equipos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipos> obtenerEquipoPorId(@PathVariable Long id) {
        Optional<Equipos> equipo = equipoService.obtenerEquipoPorId(id);
        return equipo.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Equipos> crearEquipo(@RequestBody Equipos equipo) {
        Equipos nuevoEquipo = equipoService.guardarEquipo(equipo);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEquipo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipos> actualizarEquipo(@PathVariable Long id, @RequestBody Equipo equipo) {
        if (!equipoService.obtenerEquipoPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        equipo.setId(id); // Asegúrate de establecer el ID correcto
        Equipos equipoActualizado = equipoService.guardarEquipo(equipo);
        return ResponseEntity.ok(equipoActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEquipo(@PathVariable Long id) {
        if (!equipoService.obtenerEquipoPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        equipoService.eliminarEquipo(id);
        return ResponseEntity.noContent().build();
    }
    
}
