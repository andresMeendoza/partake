package info1.info2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import info1.info2.entities.Equipos;

public interface EquiposRepository extends JpaRepository<Equipos, Long> {
    
}
