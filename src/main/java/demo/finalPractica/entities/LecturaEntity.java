package demo.finalPractica.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lecturas")
public class LecturaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "id_sensor")
    @ManyToOne
    private SensorEntity sensorEntity;
    @Column
    private LocalDateTime fecha;
    @Column
    private BigDecimal totalPrice;
}
