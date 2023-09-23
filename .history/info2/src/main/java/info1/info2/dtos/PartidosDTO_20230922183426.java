package info1.info2.dtos;

import java.time.LocalDate;

public class PartidosDTO {
    private Long id;
    private EquipoDto local;
    private EquipoDto visitante;
    private LocalDate fecha;
    private String estadio;
    private String arbitroPrincipal;

     // Getters y setters para id
     public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getters y setters para local
    public EquipoDto getLocal() {
        return local;
    }

    public void setLocal(EquipoDto local) {
        this.local = local;
    }

    // Getters y setters para visitante
    public EquipoDto getVisitante() {
        return visitante;
    }

    public void setVisitante(EquipoDto visitante) {
        this.visitante = visitante;
    }

    // Getters y setters para fecha
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    // Getters y setters para estadio
    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    // Getters y setters para arbitroPrincipal
    public String getArbitroPrincipal() {
        return arbitroPrincipal;
    }

    public void setArbitroPrincipal(String arbitroPrincipal) {
        this.arbitroPrincipal = arbitroPrincipal;
    }

    public PartidosDTO() {
        // Constructor vacío
    }

    // Constructor con parámetros
    public PartidosDTO(Long id, EquipoDto local, EquipoDto visitante, LocalDate fecha, String estadio, String arbitroPrincipal) {
        this.id = id;
        this.local = local;
        this.visitante = visitante;
        this.fecha = fecha;
        this.estadio = estadio;
        this.arbitroPrincipal = arbitroPrincipal;
    }
}
