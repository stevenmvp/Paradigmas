package interfaz1;

public class Animal implements Sonidos, Moverse {

    private String nombre;
    private int edad;

    public Animal(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
    }

    @Override 
    public void sonido() {
        System.out.println("El animal hace un sonido");
    }

    @Override 
    public void moverse() {
        System.out.println("El animal se mueve");
    }
    

}
