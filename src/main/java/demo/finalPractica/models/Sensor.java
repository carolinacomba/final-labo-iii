package demo.finalPractica.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sensor {
    private Long id;
    private String nombre;
    private String ubicacion;
    private String unidadMedida;
    private List<Lectura> lecturas;
}
