import Axios  from 'axios';
import React, { useEffect, useState } from 'react';
import { NumericFormat } from 'react-number-format';
import { Link } from 'react-router-dom';


export default function ListadoEmpleado() {

    const urlBase="http://localhost:8080/rh-app/empleados";
    const [empleado,setEmpleado]=useState([]);
    useEffect(()=>{
        cargarEmpleados();
    },[])

    const cargarEmpleados =async ()=>{
        const resultado= await Axios.get(urlBase);
        console.log("resultado de la consulta");
        console.log(resultado.data);
        setEmpleado(resultado.data);
    }
const eliminarEempleado=async (id)=>{
  await Axios.delete(urlBase+'/'+id);
  cargarEmpleados();
}
  return (
    <div className="container">
      <div className="container text-center" style={{ margin: "30px" }}>
        <h3>Sistema de Recurso Humano</h3>
        <table className="table table-striped table-hover align-middle ">
          <thead className='table-dark'>
            <tr>
              <th scope="col">ID</th>
              <th scope="col">EMPLEADO</th>
              <th scope="col">DEPARTAMENTO</th>
              <th scope="col">SALARIO</th>
              <th></th>
            </tr>
          </thead>
          <tbody>
            {
            
              
                //interamos el arreglo de empleado
                empleado.map((empleado,indice) => (
              <tr key={indice}>
                <td>{empleado.idEmpleado}</td>
                <td>{empleado.nombre}</td>
                <td>{empleado.departamento}</td>
                
                <td><NumericFormat value={empleado.sueldo}
                     displayType={'text'}
                     thousandSeparator=',' 
                     prefix={'$'}
                     decimalScale={2}  fixedDecimalScale/>
                     </td>
                <td className='text-center'>
                  <div>
                    <Link to={'/editar/'+empleado.idEmpleado}
                    className='btn btn-warning btn-sm me-3'>Editar</Link>
                    <button 
                    onClick={()=> eliminarEempleado(empleado.idEmpleado)}
                    className='btn btn-danger btn-sm me-3'
                    >Eliminar</button>
                  </div>
                  </td>     
              
            </tr>
                ))
            }
          </tbody>
        </table>
      </div>
    </div>
  );
}
