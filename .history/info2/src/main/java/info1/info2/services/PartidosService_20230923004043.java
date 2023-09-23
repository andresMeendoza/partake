package info1.info2.services;
import org.springframework.stereotype.Service;
import info1.info2.entities.Partidos;
import info1.info2.repository.PartidosRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PartidosService {
    private final PartidosRepository partidoRepository;

    public PartidosService(PartidosRepository partidoRepository) {
        this.partidoRepository = partidoRepository;
    }

    public List<Partidos> obtenerTodosLosPartidos() {
        return partidoRepository.findAll();
    }

    public Optional<Partidos> obtenerPartidoPorId(Long id) {
        return partidoRepository.findById(id);
    }

    public Partidos guardarPartido(Partidos partido) {
        return partidoRepository.save(partido);
    }

    public void eliminarPartido(Long id) {
        partidoRepository.deleteById(id);
    }
    
    public List<Partidos> obtenerPartidosPorEquipo(String nombreEquipo) {
        return partidoRepository.findByNombreEquipo(nombreEquipo);
    }
    public List<Partidos> obtenerPartidosPorFecha(LocalDate fecha) {
        return partidoRepository.findByFecha(fecha);
    }
    
    }

