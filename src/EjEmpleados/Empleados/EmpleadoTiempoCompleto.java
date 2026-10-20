package EjEmpleados.Empleados;

public class EmpleadoTiempoCompleto extends Empleado {
    private double salarioMensual;

    public EmpleadoTiempoCompleto(int identificacion, String nombre, double salarioMensual) {
        super(identificacion, nombre);
        this.salarioMensual = salarioMensual;
    }

    @Override
    public double calcularSalario() {
        return salarioMensual;
    }

}
