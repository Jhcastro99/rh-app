package human.system.resources.servicio;

import human.system.resources.modelo.Empleado;

import java.util.List;

public interface IEmpleadoServicio {
    public List<Empleado> listarEmpleados();
    public Empleado buscarEmpleadosPorId(Integer idEmpleado);
    public Empleado guadarempleados(Empleado empleado);
    public void eliminarEmpleados(Empleado empleado);
}
