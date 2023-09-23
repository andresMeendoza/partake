package info1.info2.mappers;

import info1.info2.dtos.PartidosDTO;
import info1.info2.entities.Partidos;

public class PartiosMapper {

    private final EquiposMapper equiposMapper;

    public PartiosMapper(EquiposMapper equiposMapper) {
        this.equiposMapper = equiposMapper;
    }

    public PartidosDTO toDTO(Partidos partido) {
        PartidosDTO partidoDTO = new PartidosDTO();
        partidoDTO.setId(partido.getId());
        partidoDTO.setLocal(equiposMapper.toDTO(partido.getLocal()));
        partidoDTO.setVisitante(equiposMapper.toDTO(partido.getVisitante()));
        partidoDTO.setFecha(partido.getFecha());
        partidoDTO.setEstadio(partido.getEstadio());
        partidoDTO.setArbitroPrincipal(partido.getArbitroPrincipal());
        return partidoDTO;
    }

    public Partidos toEntity(PartidosDTO partidoDTO) {
        Partidos partido = new Partidos();
        partido.setId(partidoDTO.getId());
        partido.setLocal(equiposMapper.toEntity(partidoDTO.getLocal()));
        partido.setVisitante(equiposMapper.toEntity(partidoDTO.getVisitante()));
        partido.setFecha(partidoDTO.getFecha());
        partido.setEstadio(partidoDTO.getEstadio());
        partido.setArbitroPrincipal(partidoDTO.getArbitroPrincipal());
        return partido;
    }
}
