package demo.finalPractica.controllers;

import demo.finalPractica.models.Lectura;
import demo.finalPractica.services.LecturaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/lectura")
public class LecturaController {
    @Autowired
    private LecturaService lecturaService;

    @PostMapping("/saveLectura")
    public ResponseEntity<Lectura> saveLectura(@RequestBody @Valid Lectura lectura){
        Lectura lectura11 = lecturaService.saveLectura(lectura);
        return ResponseEntity.ok(lectura11);
    }

    @PutMapping("/updateLectura/{id}")
    public ResponseEntity<Lectura> updateLectura(@PathVariable @Valid Long id, @RequestBody @Valid Lectura lectura){
        Lectura lectura11 = lecturaService.updateLectura(id, lectura);
        return ResponseEntity.ok(lectura11);
    }

    @GetMapping("/getLecturas")
    public ResponseEntity<List<Lectura>> getAllLecturas(){
        List<Lectura> lecturas = lecturaService.getAllLecturas();
        return ResponseEntity.ok(lecturas);
    }

    @GetMapping("/getLecturaById/{id}")
    public ResponseEntity<Lectura> getSensorById(@PathVariable @Valid Long id){
        Lectura lectura = lecturaService.getLecturaById(id);
        return ResponseEntity.ok(lectura);
    }

    @GetMapping("/getLecturasByDate")
    public ResponseEntity<List<Lectura>> getLecturasByDate(@RequestParam @DateTimeFormat LocalDateTime fechaDesde, @RequestParam @DateTimeFormat LocalDateTime fechaHasta) {
        List<Lectura> lecturas = lecturaService.getByDate(fechaDesde, fechaHasta);
        return ResponseEntity.ok(lecturas);
    }
    //dejo los dos métodos porque no sé si el de arriba anda bien (el de abajo tampoco sé)
    @GetMapping("/getAllLecturasByDate")
    public ResponseEntity<List<Lectura>> getAllLecturasByDate(@Valid @RequestParam String fechaDesde, @Valid @RequestParam String fechaHasta){
        LocalDateTime fechaDesde1 = LocalDateTime.parse(fechaDesde);
        LocalDateTime fechaHasta1 = LocalDateTime.parse(fechaHasta);
        List<Lectura> lecturas = lecturaService.getByDate(fechaDesde1, fechaHasta1);
        return ResponseEntity.ok(lecturas);
    }

    @DeleteMapping("/deleteLectura/{id}")
    public Boolean deleteLectura(@PathVariable @Valid Long id){
        return lecturaService.deleteLectura(id);
    }
}
