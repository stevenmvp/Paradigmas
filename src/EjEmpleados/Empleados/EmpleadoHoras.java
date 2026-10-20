package EjEmpleados.Empleados;

public class EmpleadoHoras extends Empleado {   
    private int horasTrabajadas;
    private double valorHoras;

    public EmpleadoHoras(int identificacion, String nombre, int horasTrabajadas, double valorHoras) {
        super(identificacion, nombre);
        this.horasTrabajadas = horasTrabajadas;
        this.valorHoras = valorHoras;
    }

    @Override
    public double calcularSalario(){

        return horasTrabajadas * valorHoras;
    }

}
