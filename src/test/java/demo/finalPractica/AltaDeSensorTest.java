package demo.finalPractica;

import demo.finalPractica.entities.LecturaEntity;
import demo.finalPractica.entities.SensorEntity;
import demo.finalPractica.repositories.jpa.LecturaJpaRepository;
import demo.finalPractica.repositories.jpa.SensorJpaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class AltaDeSensorTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private SensorJpaRepository sensorJpaRepository;

    @Autowired
    private LecturaJpaRepository lecturaJpaRepository;

    @Test
    public void saveSensor(){
        SensorEntity sensorEntity = new SensorEntity();
        LecturaEntity lecturaEntity = lecturaJpaRepository.getReferenceById(1000L);

        //sensorEntity.setLecturaEntity(lecturaEntity);
        sensorEntity.setNombre("Sensor L");
        sensorEntity.setUbicacion("Puerta");
        sensorEntity.setUnidadMedida("C");
        entityManager.persist(sensorEntity);
        entityManager.flush();

        SensorEntity result = sensorJpaRepository.getReferenceById(1L);

        assertEquals("Sensor", result.getNombre());
    }
}
