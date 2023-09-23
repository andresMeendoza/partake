package info1.info2.entities;

import javax.persistence.*;
import java.time.LocalDate;
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

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "estadio")
    private String estadio;

    @Column(name = "arbitro_principal")
    private String arbitroPrincipal;

    
}