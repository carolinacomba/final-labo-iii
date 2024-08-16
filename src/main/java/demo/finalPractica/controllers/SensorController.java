package demo.finalPractica.controllers;

import demo.finalPractica.models.Sensor;
import demo.finalPractica.services.SensorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sensor")
public class SensorController {
    @Autowired
    private SensorService sensorService;

    @PostMapping("/saveSensor")
    public ResponseEntity<Sensor> saveSensor(@RequestBody @Valid Sensor sensor){
        Sensor sensor1 = sensorService.saveSensor(sensor);
        return ResponseEntity.ok(sensor1);
    }

    @PutMapping("/updateSensor/{id}")
    public ResponseEntity<Sensor> updateSensor(@PathVariable @Valid Long id, @RequestBody @Valid Sensor sensor){
        Sensor sensor1 = sensorService.updateSensor(id, sensor);
        return ResponseEntity.ok(sensor1);
    }

    @GetMapping("/getSensores")
    public ResponseEntity<List<Sensor>> getAllSensores(){
        List<Sensor> sensores = sensorService.getAllSensores();
        return ResponseEntity.ok(sensores);
    }

    @GetMapping("/getSensorById/{id}")
    public ResponseEntity<Sensor> getSensorById(@PathVariable @Valid Long id){
        Sensor sensor = sensorService.getSensorById(id);
        return ResponseEntity.ok(sensor);
    }

    @GetMapping("/getSensorByNombre/{nombre}")
    public ResponseEntity<Sensor> getSensorByNombre(@PathVariable @Valid String nombre){
        Sensor sensor = sensorService.getSensorByName(nombre);
        return ResponseEntity.ok(sensor);
    }

    @DeleteMapping("/deleteSensor/{id}")
    public Boolean deleteSensor(@PathVariable @Valid Long id){
        return sensorService.deleteSensor(id);
    }
}
