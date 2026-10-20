package EjEmpleados.GestionEmpleados;

import java.util.ArrayList;

import EjEmpleados.Empleados.Empleado;

public class MetodosEmpleados {
    private ArrayList<Empleado> Lempleados;


    public MetodosEmpleados() {
        Lempleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado1){
        Lempleados.add(empleado1);
    }

    public void mostrarEmpleados(){

        for (Empleado empleado2 : Lempleados) {
            empleado2.mostrarInformacion();
            System.out.println("-------------------------------");
            
        }
    }



}
