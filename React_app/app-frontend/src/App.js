import { BrowserRouter,Routes ,Route } from "react-router-dom";
import ListadoEmpleado from "./empleado/ListadoEmpleado";
import Navegacion from "./plantilla/Navegacion";
import AgregarEmpleado from "./empleado/AgregarEmpleado"
import EditarEmpleado from "./empleado/EditarEmpleado";

function App() {
  return (
    <div class="container text-center">
      <BrowserRouter>
      <Navegacion/>
      <Routes>
        < Route exact path='/' element={<ListadoEmpleado/>}/>
        <Route exact path='/agregar' element={<AgregarEmpleado/>} />
        <Route exact path='/editar/:id' element={<EditarEmpleado/>} />
      </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
