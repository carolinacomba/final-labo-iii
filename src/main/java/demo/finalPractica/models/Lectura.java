package demo.finalPractica.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lectura {
    private Long id;
    private LocalDateTime fecha;
    private Sensor sensor;
}
