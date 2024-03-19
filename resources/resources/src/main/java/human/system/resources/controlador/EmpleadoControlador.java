package human.system.resources.controlador;

import human.system.resources.excepcion.RecursoNoEncontradoExcepcion;
import human.system.resources.modelo.Empleado;
import human.system.resources.servicio.EmpleadoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("rh-app")
@CrossOrigin(value = "http://localhost:3000")
public class EmpleadoControlador {
    private static final Logger logger = LoggerFactory.getLogger(EmpleadoControlador.class);
    private final EmpleadoServicio empleadoServicio;
    @Autowired
    public EmpleadoControlador(EmpleadoServicio empleadoServicio) {
        this.empleadoServicio = empleadoServicio;
    }



    @GetMapping("/empleados")
    public List<Empleado> obtenerEmpleados() {
        var empleados = empleadoServicio.listarEmpleados();
        empleados.forEach((empleado ->logger.info(empleado.toString())));
        return empleados;
    }
    @PostMapping("/empleados")
    public Empleado agregarEmpleados(@RequestBody Empleado empleados) {
        logger.info("empleado a agregar"+empleados);
        return empleadoServicio.guadarempleados(empleados);

    }

    @GetMapping("/empleados/{id}")
    public ResponseEntity<Empleado> buscarEmpleadoPorId(@PathVariable Integer id){
         Empleado empleado =empleadoServicio.buscarEmpleadosPorId(id);
        if(empleado == null)
            throw new RecursoNoEncontradoExcepcion("no se encontro empleado con el id: " + id);
        return ResponseEntity.ok(empleado);


    }

    @PutMapping("/empleados/{id}")
    public ResponseEntity<Empleado> actualizarEmpleado(@PathVariable Integer id,
                                                       @RequestBody Empleado empleadorecibido){
       Empleado empleado =empleadoServicio.buscarEmpleadosPorId(id);

       if (empleado==null)
           throw new RecursoNoEncontradoExcepcion("el id resibido no existe: "+id);
       empleado.setNombre(empleadorecibido.getNombre());
       empleado.setDepartamento(empleadorecibido.getDepartamento());
       empleado.setSueldo(empleadorecibido.getSueldo());
       empleadoServicio.guadarempleados(empleado);
       return ResponseEntity.ok(empleado);
    }
    @DeleteMapping("/empleados/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarEmpleados(@PathVariable Integer id){
        Empleado empleado=empleadoServicio.buscarEmpleadosPorId(id);
        if (empleado==null)
            throw new RecursoNoEncontradoExcepcion("el id resibido no existe: "+id);
        empleadoServicio.eliminarEmpleados(empleado);
        Map<String,Boolean> result = new HashMap<>();
        result.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(result);
    }

}
