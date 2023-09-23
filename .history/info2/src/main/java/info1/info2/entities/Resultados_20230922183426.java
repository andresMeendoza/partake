package info1.info2.entities;

import javax.persistence.*;

@Entity
@Table(name = "resultados")
public class Resultados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "gol_visitante")
    private Integer golVisitante;

    @Column(name = "gol_local")
    private Integer golLocal;

    @Column(name = "nro_tarjeta_roja")
    private Integer nroTarjetaRoja;

    @Column(name = "nro_tarjeta_amarilla")
    private Integer nroTarjetaAmarilla;

    // Getter para el atributo id
    public Long getId() {
        return id;
    }

    // Setter para el atributo id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter para el atributo golVisitante
    public Integer getGolVisitante() {
        return golVisitante;
    }

    // Setter para el atributo golVisitante
    public void setGolVisitante(Integer golVisitante) {
        this.golVisitante = golVisitante;
    }

    // Getter para el atributo golLocal
    public Integer getGolLocal() {
        return golLocal;
    }

    // Setter para el atributo golLocal
    public void setGolLocal(Integer golLocal) {
        this.golLocal = golLocal;
    }

    // Getter para el atributo nroTarjetaRoja
    public Integer getNroTarjetaRoja() {
        return nroTarjetaRoja;
    }

    // Setter para el atributo nroTarjetaRoja
    public void setNroTarjetaRoja(Integer nroTarjetaRoja) {
        this.nroTarjetaRoja = nroTarjetaRoja;
    }

    // Getter para el atributo nroTarjetaAmarilla
    public Integer getNroTarjetaAmarilla() {
        return nroTarjetaAmarilla;
    }

    // Setter para el atributo nroTarjetaAmarilla
    public void setNroTarjetaAmarilla(Integer nroTarjetaAmarilla) {
        this.nroTarjetaAmarilla = nroTarjetaAmarilla;
    }
}
