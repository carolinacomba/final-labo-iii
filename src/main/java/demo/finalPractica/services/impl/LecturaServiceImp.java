package demo.finalPractica.services.impl;

import demo.finalPractica.entities.*;
import demo.finalPractica.models.Lectura;
import demo.finalPractica.repositories.jpa.LecturaJpaRepository;
import demo.finalPractica.repositories.jpa.SensorJpaRepository;
import demo.finalPractica.services.LecturaService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LecturaServiceImp implements LecturaService {
    @Autowired
    private SensorJpaRepository sensorJpaRepository;

    @Autowired
    private LecturaJpaRepository lecturaJpaRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public Lectura getLecturaById(Long id) {
        LecturaEntity lecturaEntity = lecturaJpaRepository.getReferenceById(id);
        Lectura lectura = modelMapper.map(lecturaEntity, Lectura.class);
        return lectura;
    }

    @Override
    public Lectura saveLectura(Lectura lectura) {
        LecturaEntity lecturaEntity = modelMapper.map(lectura, LecturaEntity.class);
        lecturaJpaRepository.save(lecturaEntity);
        return modelMapper.map(lecturaEntity, Lectura.class);
    }

    @Override
    public List<Lectura> getAllLecturas() {
        List<LecturaEntity> lecturaEntities = lecturaJpaRepository.findAll();
        List<Lectura> lecturas = new ArrayList<>();

        for(LecturaEntity carEntity : lecturaEntities){
            lecturas.add(modelMapper.map(carEntity, Lectura.class));
        }
        return lecturas;
    }

    @Override
    public Lectura updateLectura(Long id, Lectura lectura) {
        Optional<LecturaEntity> lecturaEntityOptional = lecturaJpaRepository.findById(id);
        if (lecturaEntityOptional.isPresent()) {
            LecturaEntity lecturaEntity = lecturaEntityOptional.get();
            lecturaEntity.setFecha(lectura.getFecha());

            SensorEntity sensorEntity = sensorJpaRepository.getReferenceById(lectura.getSensor().getId());
            lecturaEntity.setSensorEntity(sensorEntity);

            lecturaJpaRepository.save(lecturaEntity);
            return modelMapper.map(lecturaEntity, Lectura.class);
        } else {
            throw new EntityNotFoundException("No se encontró la lectura con ese ID");
        }
    }

    @Override
    public Boolean deleteLectura(Long id) {
        Optional<LecturaEntity> lecturaEntityOptional = lecturaJpaRepository.findById(id);
        if (lecturaEntityOptional.isPresent()) {
            LecturaEntity lecturaEntity = lecturaEntityOptional.get();
            lecturaEntity.setSensorEntity(null);
            lecturaJpaRepository.save(lecturaEntity);
            lecturaJpaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Lectura> getByDate(LocalDateTime fechaDesde, LocalDateTime fechaHasta) {
        List<LecturaEntity> lecturaEntities = lecturaJpaRepository.findAll();
        List<Lectura> lecturas = new ArrayList<>();

        for (LecturaEntity lecturaEntity : lecturaEntities) {
            LocalDateTime fechaLectura = lecturaEntity.getFecha();
            if (fechaLectura.isEqual(fechaDesde) || (fechaLectura.isAfter(fechaHasta) && fechaLectura.isBefore(fechaHasta))) {
                Lectura lectura = modelMapper.map(lecturaEntity, Lectura.class);
                lecturas.add(lectura);
            }
        }

        if (!lecturas.isEmpty()) {
            return lecturas;
        } else {
            throw new EntityNotFoundException("No hay lecturas disponibles para el rango de fechas");
        }
    }
}
