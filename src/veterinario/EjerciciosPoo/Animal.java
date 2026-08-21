package veterinario.EjerciciosPoo;

public class Animal {
private int id;
private String nombre;
private int edad;
private String raza;
private String SonidoAnimal;


    public Animal(int id, String nombre, int edad, String raza , String SonidoAnimal) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.raza = raza;
        this.SonidoAnimal = SonidoAnimal;
    }
    public Animal(int id, String nombre, int edad) {
    this.id = id;
    this.nombre = nombre;
    this.edad = edad;
    this.raza = "Sin definir";
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

    public String getRaza() {
        return raza;
    }
    
    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getSonidoAnimal() {
        return SonidoAnimal;
    }
    public void setSonidoAnimal(String SonidoAnimal) {
        this.SonidoAnimal = SonidoAnimal;
    }

    public void mostrarInformacion() {
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Raza: " + raza);
    }

    public void hacerSonido(){
            System.out.println("El animal hace un sonido"+ SonidoAnimal);

    }

}