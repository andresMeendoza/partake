package info1.info2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import info1.info2.dtos.EquipoDto;
import info1.info2.entities.Equipos;
import info1.info2.services.EquipoService;
import info1.info2.mappers.EquiposMapper; // Importa el mapper

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/equipos")
public class EquiposController {
    private final EquipoService equipoService;
    private final EquiposMapper equiposMapper; // Inyecta el mapper

    @Autowired
    public EquiposController(EquipoService equipoService, EquiposMapper equiposMapper) {
        this.equipoService = equipoService;
        this.equiposMapper = equiposMapper; // Asigna el mapper
    }

    @GetMapping
    public ResponseEntity<List<EquipoDto>> obtenerTodosLosEquipos() {
        List<Equipos> equipos = equipoService.obtenerTodosLosEquipos();
        List<EquipoDto> equiposDTO = equipos.stream()
                .map(equiposMapper::toDTO) // Convierte las entidades en DTO
                .collect(Collectors.toList());
        return ResponseEntity.ok(equiposDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipoDto> obtenerEquipoPorId(@PathVariable Long id) {
        Optional<Equipos> equipo = equipoService.obtenerEquipoPorId(id);
        
        if (equipo.isPresent()) {
            EquipoDto equipoDTO = equiposMapper.toDTO(equipo.get());
            return ResponseEntity.ok(equipoDTO);
        } else {
            throw new EquipoNotFoundException(id);
        }
    }
    
    @PostMapping
    public ResponseEntity<EquipoDto> crearEquipo(@RequestBody EquipoDto equipoDTO) {
        Equipos equipo = equiposMapper.toEntity(equipoDTO); // Convierte el DTO en entidad
        Equipos nuevoEquipo = equipoService.guardarEquipo(equipo);
        EquipoDto nuevoEquipoDTO = equiposMapper.toDTO(nuevoEquipo); // Convierte la entidad en DTO
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEquipoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EquipoDto> actualizarEquipo(@PathVariable Long id, @RequestBody EquipoDto equipoDTO) {
        if (!equipoService.obtenerEquipoPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Equipos equipo = equiposMapper.toEntity(equipoDTO); // Convierte el DTO en entidad
        equipo.setId(id); 
        Equipos equipoActualizado = equipoService.guardarEquipo(equipo);
        EquipoDto equipoActualizadoDTO = equiposMapper.toDTO(equipoActualizado); // Convierte la entidad en DTO
        return ResponseEntity.ok(equipoActualizadoDTO);
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
