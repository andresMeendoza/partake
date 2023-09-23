package info1.info2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import info1.info2.dtos.ResultadosDTO;
import info1.info2.entities.Resultados;
import info1.info2.services.ResultadosServic;
import info1.info2.mappers.ResultadosMapper; // Importa el mapper

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/resultados")
public class ResultadosController {
    private final ResultadosServic resultadoService;
    private final ResultadosMapper resultadosMapper; // Inyecta el mapper

   
    public ResultadosController(ResultadosServic resultadoService, ResultadosMapper resultadosMapper) {
        this.resultadoService = resultadoService;
        this.resultadosMapper = resultadosMapper; // Asigna el mapper
    }

    @GetMapping
    public ResponseEntity<List<ResultadosDTO>> obtenerTodosLosResultados() {
        List<Resultados> resultados = resultadoService.obtenerTodosLosResultados();
        List<ResultadosDTO> resultadosDTO = resultados.stream()
                .map(resultadosMapper::toDTO) // Convierte las entidades en DTO
                .collect(Collectors.toList());
        return ResponseEntity.ok(resultadosDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResultadosDTO> obtenerResultadoPorId(@PathVariable Long id) {
        Optional<Resultados> resultado = resultadoService.obtenerResultadoPorId(id);
        return resultado.map(resultadosMapper::toDTO) // Convierte la entidad en DTO
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ResultadosDTO> crearResultado(@RequestBody ResultadosDTO resultadoDTO) {
        Resultados resultado = resultadosMapper.toEntity(resultadoDTO); // Convierte el DTO en entidad
        Resultados nuevoResultado = resultadoService.guardarResultado(resultado);
        ResultadosDTO nuevoResultadoDTO = resultadosMapper.toDTO(nuevoResultado); // Convierte la entidad en DTO
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoResultadoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResultadosDTO> actualizarResultado(@PathVariable Long id, @RequestBody ResultadosDTO resultadoDTO) {
        Resultados resultado = resultadosMapper.toEntity(resultadoDTO); // Convierte el DTO en entidad
        Resultados resultadoActualizado = resultadoService.actualizarResultado(id, resultado);
        if (resultadoActualizado == null) {
            return ResponseEntity.notFound().build();
        }
        ResultadosDTO resultadoActualizadoDTO = resultadosMapper.toDTO(resultadoActualizado); // Convierte la entidad en DTO
        return ResponseEntity.ok(resultadoActualizadoDTO);
    }
}

    

