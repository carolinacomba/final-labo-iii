package demo.finalPractica.repositories.jpa;

import demo.finalPractica.entities.LecturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LecturaJpaRepository extends JpaRepository<LecturaEntity, Long> {
}
