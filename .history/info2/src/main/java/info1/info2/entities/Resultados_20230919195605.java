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

    
}
