package info1.info2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import info1.info2.entities.Resultados;
import info1.info2.services.ResultadosServic;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/resultados")
public class ResultadosController {
    private final ResultadosServic resultadoService;

    @Autowired
    public ResultadosController(ResultadosServic resultadoService) {
        this.resultadoService = resultadoService;
    }

    @GetMapping
    public ResponseEntity<List<Resultados>> obtenerTodosLosResultados() {
        List<Resultados> resultados = resultadoService.obtenerTodosLosResultados();
        return ResponseEntity.ok(resultados);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resultados> obtenerResultadoPorId(@PathVariable Long id) {
        Optional<Resultados> resultado = resultadoService.obtenerResultadoPorId(id);
        return resultado.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Resultados> crearResultado(@RequestBody Resultados resultado) {
        Resultados nuevoResultado = resultadoService.guardarResultado(resultado);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoResultado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resultados> actualizarResultado(@PathVariable Long id, @RequestBody Resultados resultado) {
        Resultados resultadoActualizado = resultadoService.actualizarResultado(id, resultado);
        if (resultadoActualizado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(resultadoActualizado);
    }
}

    

