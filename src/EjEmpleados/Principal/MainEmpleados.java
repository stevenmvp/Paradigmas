package EjEmpleados.Principal;

import EjEmpleados.Empleados.Empleado;
import EjEmpleados.Empleados.EmpleadoHoras;
import EjEmpleados.Empleados.EmpleadoTiempoCompleto;
import EjEmpleados.GestionEmpleados.MetodosEmpleados;


public class MainEmpleados {

    public static void main(String[] args){

        MetodosEmpleados gestion = new MetodosEmpleados();
        Empleado empleado3 = new EmpleadoHoras(103, "Pedro", 40, 50000);
        Empleado empleadoT = new EmpleadoTiempoCompleto(205, "Ana", 2000000);

        gestion.agregarEmpleado(empleado3);
        gestion.agregarEmpleado(empleadoT);

        gestion.mostrarEmpleados();


    }

}
