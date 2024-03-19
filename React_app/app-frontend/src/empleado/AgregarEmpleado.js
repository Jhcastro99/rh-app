import Axios  from "axios";
import { useState } from "react";
import {useNavigate} from "react-router-dom"

export default function AgregarEmpleado(){
let navegacion = useNavigate();
  const [empleado , setEmpleado] =useState({
    nombre:"",
    departamento:"",
    sueldo:""
  });

  const {nombre,departamento,sueldo} =empleado;

  const onInputChenge = (e) => {
    setEmpleado({...empleado,[e.target.name]:e.target.value});
  }
  const onSubmit = async (e) => {
    e.preventDefault();
    const urlbase="http://localhost:8080/rh-app/empleados";
    await Axios.post(urlbase,empleado);
    navegacion("/");

  }

    return(
        <div class="container " style={{padding:"30px"}}>
    <div class="row">
      <div class="col-md-6 offset-md-3">
        <h1 style={{padding:"15px"}}>Agregar empleado</h1>
        <form onSubmit={(e)=> onSubmit(e)}>
          <div class="form-group">
            <label htmlFor="nombre">Nombre:</label>
            <input type="text" class="form-control  border border-1 border-primary"
             id="nombre" name="nombre" placeholder="Ingrese su nombre"
              required={true} value={nombre} onChange={(e)=>onInputChenge(e)}/>
          </div>
          <div class="form-group">
            <label htmlFor="departamento">Departamento:</label>
            <input type="text" class="form-control border border-1 border-primary "
             id="departamento" name="departamento" placeholder="Ingrese su departamento"
             value={departamento} onChange={(e)=>onInputChenge(e)}/>
          </div>
          <div class="form-group">
            <label htmlFor="sueldo">Sueldo:</label>
            <input type="number" class="form-control border border-1 border-primary" 
            step="any" id="sueldo" name="sueldo" placeholder="Ingrese su sueldo"
            value={sueldo} onChange={(e)=>onInputChenge(e)}/>
          </div>
          <div className="text-center " style={{padding:"15px"}}>
          <button type="submit" class="btn btn-warning btn-sm me-3">Enviar</button>
          
          <a href="/" className="btn btn-danger btn">regresar</a>
          </div>
        </form>
      </div>
    </div>
  </div>
    );

    

}