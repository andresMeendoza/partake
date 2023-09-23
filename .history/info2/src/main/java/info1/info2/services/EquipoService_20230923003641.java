package info1.info2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info1.info2.entities.Equipos;
import info1.info2.repository.EquiposRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoService {
    private final EquiposRepository equipoRepository;

    
    public EquipoService(EquiposRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    public List<Equipos> obtenerTodosLosEquipos() {
        return equipoRepository.findAll();
    }

    public Optional<Equipos> obtenerEquipoPorId(Long id) {
        return equipoRepository.findById(id);
    }

    public Equipos guardarEquipo(Equipos equipos) {
        return equipoRepository.save(equipos);
    }

    public void eliminarEquipo(Long id) {
        equipoRepository.deleteById(id);
    }
}
