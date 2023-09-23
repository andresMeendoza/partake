package info1.info2.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import info1.info2.Excepciones.EquipoNotFoundExcepcion;
import info1.info2.dtos.EquipoDto;
import info1.info2.entities.Equipos;
import info1.info2.services.EquipoService;
import info1.info2.mappers.EquiposMapper; 
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/equipos")
public class EquiposController {
    private final EquipoService equipoService;
    private final EquiposMapper equiposMapper; 

   
    public EquiposController(EquipoService equipoService, EquiposMapper equiposMapper) {
        this.equipoService = equipoService;
        this.equiposMapper = equiposMapper; 
    }

    @GetMapping
    public ResponseEntity<List<EquipoDto>> obtenerTodosLosEquipos() {
        List<Equipos> equipos = equipoService.obtenerTodosLosEquipos();
        List<EquipoDto> equiposDTO = equipos.stream()
                .map(equiposMapper::toDTO) 
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
            throw new EquipoNotFoundExcepcion(id);
        }
    }
    
    @PostMapping
    public ResponseEntity<EquipoDto> crearEquipo(@RequestBody EquipoDto equipoDTO) {
        Equipos equipo = equiposMapper.toEntity(equipoDTO); 
        Equipos nuevoEquipo = equipoService.guardarEquipo(equipo);
        EquipoDto nuevoEquipoDTO = equiposMapper.toDTO(nuevoEquipo); 
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEquipoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EquipoDto> actualizarEquipo(@PathVariable Long id, @RequestBody EquipoDto equipoDTO) {
        Optional<Equipos> equipoExistente = equipoService.obtenerEquipoPorId(id);
        
        if (equipoExistente.isPresent()) {
            Equipos equipo = equiposMapper.toEntity(equipoDTO);
            equipo.setId(id);
            Equipos equipoActualizado = equipoService.guardarEquipo(equipo);
            EquipoDto equipoActualizadoDTO = equiposMapper.toDTO(equipoActualizado);
            return ResponseEntity.ok(equipoActualizadoDTO);
        } else {
            throw new EquipoNotFoundExcepcion(id);
        }
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
