package info1.info2.dtos;

public class ResultadosDTO {
    private Long id;
    private Integer golVisitante;
    private Integer golLocal;
    private Integer nroTarjetaRoja;
    private Integer nroTarjetaAmarilla;

    // Getters y setters para id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getters y setters para golVisitante
    public Integer getGolVisitante() {
        return golVisitante;
    }

    public void setGolVisitante(Integer golVisitante) {
        this.golVisitante = golVisitante;
    }

    // Getters y setters para golLocal
    public Integer getGolLocal() {
        return golLocal;
    }

    public void setGolLocal(Integer golLocal) {
        this.golLocal = golLocal;
    }

    // Getters y setters para nroTarjetaRoja
    public Integer getNroTarjetaRoja() {
        return nroTarjetaRoja;
    }

    public void setNroTarjetaRoja(Integer nroTarjetaRoja) {
        this.nroTarjetaRoja = nroTarjetaRoja;
    }

    // Getters y setters para nroTarjetaAmarilla
    public Integer getNroTarjetaAmarilla() {
        return nroTarjetaAmarilla;
    }

    public void setNroTarjetaAmarilla(Integer nroTarjetaAmarilla) {
        this.nroTarjetaAmarilla = nroTarjetaAmarilla;
    }
}
