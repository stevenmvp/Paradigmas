package interfaz1;

public class Perro extends Animal {

    public Perro(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public void sonido() {
        System.out.println("El perro ladra");
    }

    @Override 
    public void moverse() {
        System.out.println("El perro corre");
    }

}
