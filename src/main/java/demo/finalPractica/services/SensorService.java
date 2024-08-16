package demo.finalPractica.services;

import demo.finalPractica.models.Sensor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SensorService {
    Sensor getSensorById(Long id);

    Sensor getSensorByName(String nombre);

    Sensor saveSensor(Sensor sensor);

    List<Sensor> getAllSensores();

    Sensor updateSensor(Long id, Sensor sensor);

    Boolean deleteSensor(Long id);
}
