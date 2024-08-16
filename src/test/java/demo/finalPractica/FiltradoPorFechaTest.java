package demo.finalPractica;

import demo.finalPractica.entities.LecturaEntity;
import demo.finalPractica.models.Lectura;
import demo.finalPractica.repositories.jpa.LecturaJpaRepository;
import demo.finalPractica.repositories.jpa.SensorJpaRepository;
import demo.finalPractica.services.LecturaService;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class FiltradoPorFechaTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private SensorJpaRepository sensorJpaRepository;

    @Autowired
    private LecturaJpaRepository lecturaJpaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private LecturaService lecturaService;
    @Test
    public void getByDate() {
        LocalDateTime fechaDesde = LocalDateTime.of(2023, 1, 1, 0, 0);
        LocalDateTime fechaHasta = LocalDateTime.of(2023, 1, 31, 23, 59);

        LecturaEntity lectura1 = new LecturaEntity();
        lectura1.setFecha(LocalDateTime.of(2023, 1, 10, 12, 0));
        LecturaEntity lectura2 = new LecturaEntity();
        lectura2.setFecha(LocalDateTime.of(2023, 1, 20, 17, 0));

        List<LecturaEntity> lecturaEntities = new ArrayList<>();
        lecturaEntities.add(lectura1);
        lecturaEntities.add(lectura2);

        Lectura nuevaLectura = new Lectura();
        nuevaLectura.setFecha(lectura1.getFecha());

        Lectura nuevaLectura2 = new Lectura();
        nuevaLectura2.setFecha(lectura2.getFecha());

        List<Lectura> addLecturas = new ArrayList<>();
        addLecturas.add(nuevaLectura);
        addLecturas.add(nuevaLectura2);

        List<Lectura> nuevasLecturas = lecturaService.getByDate(fechaDesde, fechaHasta);
        assertEquals(addLecturas, nuevasLecturas);
    }
}
