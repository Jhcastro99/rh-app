package human.system.resources.servicio;

import human.system.resources.modelo.Empleado;
import human.system.resources.repositorio.EmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmpleadoServicio implements IEmpleadoServicio{


    private final EmpleadoRepositorio empleadoRepositorio;
    @Autowired
    public EmpleadoServicio(EmpleadoRepositorio empleadoRepositorio) {
        this.empleadoRepositorio = empleadoRepositorio;
    }

    @Override
    public List<Empleado> listarEmpleados() {
        return empleadoRepositorio.findAll();
    }

    @Override
    public Empleado buscarEmpleadosPorId(Integer idEmpleado) {
        Empleado empleado=empleadoRepositorio.findById(idEmpleado).orElse(null);
        return empleado;
    }

    @Override
    public Empleado guadarempleados(Empleado empleado) {
        return empleadoRepositorio.save(empleado);
    }

    @Override
    public void eliminarEmpleados(Empleado empleado) {
        empleadoRepositorio.delete(empleado);

    }
}
