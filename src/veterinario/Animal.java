package veterinario;

public class Animal {
private int id;
private String nombre;
private int edad;
    public Animal(int id, String nombre, int edad) {
    this.id = id;
    this.nombre = nombre;
    this.edad = edad;
    }
    
    public void move(){
        System.out.println("El animal se mueve");
    
    }
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
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
}