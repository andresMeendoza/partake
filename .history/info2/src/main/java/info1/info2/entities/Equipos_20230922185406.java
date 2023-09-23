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
import javax.persistence.*;
@Entity
@Table(name = "equipos")

public class Equipos {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del equipo es obligatorio")
    private String nombre;

    @NotBlank(message = "El lugar de juego es obligatorio")
    private String lugarJuego;

    @NotBlank(message = "El director técnico es obligatorio")
    private String directorTecnico;
    @OneToMany(mappedBy = "local")
    private List<Partidos> partidosLocal;

    @OneToMany(mappedBy = "visitante")
    private List<Partidos> partidosVisitante;

 
// Getter para el atributo id
public Long getId() {
    return id;
}

// Setter para el atributo id
public void setId(Long id) {
    this.id = id;
}

// Getter para el atributo nombre
public String getNombre() {
    return nombre;
}

// Setter para el atributo nombre
public void setNombre(String nombre) {
    this.nombre = nombre;
}

// Getter para el atributo lugarJuego
public String getLugarJuego() {
    return lugarJuego;
}

// Setter para el atributo lugarJuego
public void setLugarJuego(String lugarJuego) {
    this.lugarJuego = lugarJuego;
}

// Getter para el atributo directorTecnico
public String getDirectorTecnico() {
    return directorTecnico;
}

// Setter para el atributo directorTecnico
public void setDirectorTecnico(String directorTecnico) {
    this.directorTecnico = directorTecnico;
}

// Getters y setters para las relaciones partidosLocal y partidosVisitante
public List<Partidos> getPartidosLocal() {
    return partidosLocal;
}

public void setPartidosLocal(List<Partidos> partidosLocal) {
    this.partidosLocal = partidosLocal;
}

public List<Partidos> getPartidosVisitante() {
    return partidosVisitante;
}

public void setPartidosVisitante(List<Partidos> partidosVisitante) {
    this.partidosVisitante = partidosVisitante;
}
}
