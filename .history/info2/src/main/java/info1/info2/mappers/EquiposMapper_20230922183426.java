package info1.info2.mappers;

import info1.info2.dtos.EquipoDto;
import info1.info2.entities.Equipos;

public class EquiposMapper {

    public EquipoDto toDTO(Equipos equipo) {
        EquipoDto equipoDTO = new EquipoDto();
        equipoDTO.setId(equipo.getId());
        equipoDTO.setNombre(equipo.getNombre());
        equipoDTO.setLugarJuego(equipo.getLugarJuego());
        equipoDTO.setDirectorTecnico(equipo.getDirectorTecnico());
        return equipoDTO;
    }

    public Equipos toEntity(EquipoDto equipoDTO) {
        Equipos equipo = new Equipos();
        equipo.setId(equipoDTO.getId());
        equipo.setNombre(equipoDTO.getNombre());
        equipo.setLugarJuego(equipoDTO.getLugarJuego());
        equipo.setDirectorTecnico(equipoDTO.getDirectorTecnico());
        return equipo;
    }
}

