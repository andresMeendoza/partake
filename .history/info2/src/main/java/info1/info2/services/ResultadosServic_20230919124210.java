package info1.info2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info1.info2.entities.Resultados;
import info1.info2.repository.ResultadosRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ResultadosServic {
    private final ResultadosRepository resultadoRepository;


    @Autowired
    public ResultadosServic(ResultadosRepository resultadoRepository) {
        this.resultadoRepository = resultadoRepository;
    }

    public List<Resultados> obtenerTodosLosResultados() {
        return resultadoRepository.findAll();
    }

    public Optional<Resultados> obtenerResultadoPorId(Long id) {
        return resultadoRepository.findById(id);
    }

    public Resultados guardarResultado(Resultados resultado) {
        return resultadoRepository.save(resultado);
    }

    public void eliminarResultado(Long id) {
        resultadoRepository.deleteById(id);
    }
    public Resultados actualizarResultado(Long id, Resultados resultadoActualizado) {
        Optional<Resultados> resultadoExistente = resultadoRepository.findById(id);

        if (resultadoExistente.isPresent()) {
            Resultados resultado = resultadoExistente.get();
            resultadoRepository.save(resultado);
            return resultado;
        } else {
            
            return null;
        }
    }
}
