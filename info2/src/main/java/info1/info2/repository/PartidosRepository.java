package info1.info2.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import info1.info2.entities.Partidos;

public interface PartidosRepository extends JpaRepository<Partidos, Long> {
  
    @Query("SELECT p FROM Partidos p WHERE p.equipoLocal.nombre = :nombreEquipo OR p.equipoVisitante.nombre = :nombreEquipo")
    List<Partidos> findByNombreEquipo(@Param("nombreEquipo") String nombreEquipo);

    @Query("SELECT p FROM Partidos p WHERE p.fecha = :fecha")
    List<Partidos> findByFecha(@Param("fecha") LocalDate fecha);
}
