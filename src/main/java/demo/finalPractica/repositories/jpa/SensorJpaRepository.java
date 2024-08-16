package demo.finalPractica.repositories.jpa;

import demo.finalPractica.entities.SensorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorJpaRepository extends JpaRepository<SensorEntity, Long> {
    @Query("SELECT s FROM SensorEntity s WHERE s.nombre = :nombre")
    SensorEntity findByNombre(String nombre);
}
