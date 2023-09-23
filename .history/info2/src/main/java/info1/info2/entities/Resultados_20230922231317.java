package info1.info2.entities;

import javax.persistence.*;

import jakarta.validation.constraints.Min;

@Entity
@Table(name = "resultados")
public class Resultados {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(value = 0, message = "El número de goles visitantes no puede ser negativo")
    private Integer golVisitante;

    @Min(value = 0, message = "El número de goles locales no puede ser negativo")
    private Integer golLocal;

    @Min(value = 0, message = "El número de tarjetas rojas no puede ser negativo")
    private Integer nroTarjetaRoja;

    @Min(value = 0, message = "El número de tarjetas amarillas no puede ser negativo")
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
