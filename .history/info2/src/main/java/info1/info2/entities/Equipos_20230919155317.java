package info1.info2.entities;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "equipos")

public class Equipos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "lugar_juego")
    private String lugarJuego;

    @Column(name = "director_tecnico")
    private String directorTecnico;

    @OneToMany(mappedBy = "local")
    private List<Partidos> partidosLocal;

    @OneToMany(mappedBy = "visitante")
    private List<Partidos> partidosVisitante;

    public void setId(Long id) {
        this.id = id;
    }

}