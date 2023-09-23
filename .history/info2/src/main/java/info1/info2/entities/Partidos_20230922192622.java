package info1.info2.entities;

import javax.persistence.*;

import jakarta.validation.constraints.FutureOrPresent;
jakarta.validation.constraints.*;
import java.time.LocalDate;
jakarta.validation.constraints.*;
@Entity
@Table(name = "partidos")
public class Partidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL) 
    @JoinColumn(name = "marcador_id") 
    private Resultados marcador;

    @ManyToOne
    @JoinColumn(name = "equipo_local_id")
    private Equipos local;

    @ManyToOne
    @JoinColumn(name = "equipo_visitante_id")
    private Equipos visitante;

    
     @FutureOrPresent(message = "La fecha del partido debe ser en el presente o en el futuro")
    private LocalDate fecha;
 
    @NotBlank(message = "El estadio es obligatorio")
    private String estadio;

    @Column(name = "arbitro_principal")
    private String arbitroPrincipal;

    public Long getId() {
        return id;
    }

    // Setter para el atributo id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter para el atributo marcador
    public Resultados getMarcador() {
        return marcador;
    }

    // Setter para el atributo marcador
    public void setMarcador(Resultados marcador) {
        this.marcador = marcador;
    }

    // Getter para el atributo local
    public Equipos getLocal() {
        return local;
    }

    // Setter para el atributo local
    public void setLocal(Equipos local) {
        this.local = local;
    }

    // Getter para el atributo visitante
    public Equipos getVisitante() {
        return visitante;
    }

    // Setter para el atributo visitante
    public void setVisitante(Equipos visitante) {
        this.visitante = visitante;
    }

    // Getter para el atributo fecha
    public LocalDate getFecha() {
        return fecha;
    }

    // Setter para el atributo fecha
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    // Getter para el atributo estadio
    public String getEstadio() {
        return estadio;
    }

    // Setter para el atributo estadio
    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    // Getter para el atributo arbitroPrincipal
    public String getArbitroPrincipal() {
        return arbitroPrincipal;
    }

    // Setter para el atributo arbitroPrincipal
    public void setArbitroPrincipal(String arbitroPrincipal) {
        this.arbitroPrincipal = arbitroPrincipal;
    }

}