package info1.info2.mappers;

import info1.info2.dtos.ResultadosDTO;
import info1.info2.entities.Resultados;

public class ResultadosMapper {

    public ResultadosDTO toDTO(Resultados resultados) {
        ResultadosDTO resultadosDTO = new ResultadosDTO();
        resultadosDTO.setId(resultados.getId());
        resultadosDTO.setGolVisitante(resultados.getGolVisitante());
        resultadosDTO.setGolLocal(resultados.getGolLocal());
        resultadosDTO.setNroTarjetaRoja(resultados.getNroTarjetaRoja());
        resultadosDTO.setNroTarjetaAmarilla(resultados.getNroTarjetaAmarilla());
        return resultadosDTO;
    }

    public Resultados toEntity(ResultadosDTO resultadosDTO) {
        Resultados resultados = new Resultados();
        resultados.setId(resultadosDTO.getId());
        resultados.setGolVisitante(resultadosDTO.getGolVisitante());
        resultados.setGolLocal(resultadosDTO.getGolLocal());
        resultados.setNroTarjetaRoja(resultadosDTO.getNroTarjetaRoja());
        resultados.setNroTarjetaAmarilla(resultadosDTO.getNroTarjetaAmarilla());
        return resultados;
    }
}
