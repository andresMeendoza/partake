package info1.info2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import info1.info2.entities.Resultados;

public interface ResultadosRepository extends JpaRepository<Resultados, Long> {
   
}