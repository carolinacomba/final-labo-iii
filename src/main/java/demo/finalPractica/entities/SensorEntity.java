package demo.finalPractica.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sensores")
public class SensorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "id_lectura")
    @OneToMany
    private List<LecturaEntity> lecturaEntity;
    @Column
    private String nombre;
    @Column
    private String ubicacion;
    @Column
    private String unidadMedida;
}
