package human.system.resources.modelo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@Table
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
   private Integer idEmpleado;
   private String nombre;
   private String departamento;
   private Double sueldo;


}
