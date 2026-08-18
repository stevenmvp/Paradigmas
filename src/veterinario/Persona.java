package veterinario;


public class Persona {
    private int id;
    private String nombre;
    private int edad;
    private String Cargo;
    private String telefono;
    private String email;
    private String direccion;
    private String cedula;
    
    public Persona() {
    }
    
    public Persona(int id, String nombre, int edad, String cargo, String telefono, String email, String direccion, String cedula) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.Cargo = cargo;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.cedula = cedula;
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
    
    public String getCargo() {
        return Cargo;
    }
    
    public void setCargo(String cargo) {
        this.Cargo = cargo;
    }
    
    public String getTelefono() {
        return telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public String getCedula() {
        return cedula;
    }
    
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    public void mostrarInformacion() {
        System.out.println("ID: " + id + ", Nombre: " + nombre + ", Edad: " + edad + ", Cargo: " + Cargo);
    }
    
    public void actualizarContacto(String telefono, String email) {
        this.telefono = telefono;
        this.email = email;
    }
    
    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", Cargo='" + Cargo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", direccion='" + direccion + '\'' +
                ", cedula='" + cedula + '\'' +
                '}';
    }
}
