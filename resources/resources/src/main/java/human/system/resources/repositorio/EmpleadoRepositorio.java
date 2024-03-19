package human.system.resources.repositorio;

import human.system.resources.modelo.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpleadoRepositorio  extends JpaRepository<Empleado, Integer> {


}