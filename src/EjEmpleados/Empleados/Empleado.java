package EjEmpleados.Empleados;

public abstract class Empleado {

    protected int identificacion;
    protected String nombre;

    public Empleado(int identificacion, String nombre){
        this.identificacion = identificacion;
        this.nombre = nombre;
    }

    public abstract double calcularSalario();

    public void mostrarInformacion(){
        System.out.println("ID: " +identificacion);
        System.out.println("nombre: " +nombre);
        System.out.println("salario: " +calcularSalario());
    }

}
