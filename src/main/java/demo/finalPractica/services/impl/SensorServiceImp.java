package demo.finalPractica.services.impl;

import demo.finalPractica.entities.SensorEntity;
import demo.finalPractica.models.Sensor;
import demo.finalPractica.repositories.jpa.SensorJpaRepository;
import demo.finalPractica.services.SensorService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SensorServiceImp implements SensorService {
    @Autowired
    private SensorJpaRepository sensorJpaRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public Sensor getSensorById(Long id) {
        SensorEntity sensorEntity = sensorJpaRepository.getReferenceById(id);
        Sensor sensor = modelMapper.map(sensorEntity, Sensor.class);
        return sensor;
    }

    @Override
    public Sensor getSensorByName(String nombre) {
        SensorEntity sensorEntity = sensorJpaRepository.findByNombre(nombre);
        if (sensorEntity != null) {
            return modelMapper.map(sensorEntity, Sensor.class);
        } else {
            throw new EntityNotFoundException("No se encontró el sensor con ese nombre");
        }
    }

    @Override
    public Sensor saveSensor(Sensor sensor) {
        SensorEntity sensorEntity = modelMapper.map(sensor, SensorEntity.class);
        sensorJpaRepository.save(sensorEntity);
        return modelMapper.map(sensorEntity, Sensor.class);
    }

    @Override
    public List<Sensor> getAllSensores() {
        List<SensorEntity> sensorEntities = sensorJpaRepository.findAll();
        List<Sensor> sensores = new ArrayList<>();

        for(SensorEntity sensorEntity : sensorEntities){
            sensores.add(modelMapper.map(sensorEntity, Sensor.class));
        }
        return sensores;
    }

    @Override
    public Sensor updateSensor(Long id, Sensor sensor) {
        Optional<SensorEntity> sensorEntity = sensorJpaRepository.findById(id);
        if (sensorEntity.isPresent()) {
            SensorEntity sensorEntity1 = sensorEntity.get();
            sensorEntity1.setNombre(sensor.getNombre());
            sensorEntity1.setUbicacion(sensor.getUbicacion());
            sensorEntity1.setUnidadMedida(sensor.getUnidadMedida());

            sensorJpaRepository.save(sensorEntity1);
            return modelMapper.map(sensorEntity1, Sensor.class);
        } else {
            throw new EntityNotFoundException("No se encontró el sensor con ese ID");
        }
    }

    @Override
    public Boolean deleteSensor(Long id) {
        Optional<SensorEntity> sensorEntity = sensorJpaRepository.findById(id);
        if (sensorEntity.isPresent()) {
            SensorEntity sensorEntity1 = sensorEntity.get();
            sensorEntity1.setLecturaEntity(null);
            sensorJpaRepository.save(sensorEntity1);
            sensorJpaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
