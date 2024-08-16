package demo.finalPractica.services;

import demo.finalPractica.models.Lectura;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public interface LecturaService {
    Lectura getLecturaById(Long id);

    Lectura saveLectura(Lectura lectura);

    List<Lectura> getAllLecturas();

    Lectura updateLectura(Long id, Lectura lectura);

    Boolean deleteLectura(Long id);

    List<Lectura> getByDate(LocalDateTime fechaDesde, LocalDateTime fechaHasta);
}
