package Eventos;

public class Persona {
    private final int idPersona;
    private String nombre;
    private String correo;
    private String cedula;
    private String telefono;
    private boolean sesionActiva;

    public Persona(int idPersona, String nombre, String correo, String cedula, String telefono) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.correo = correo;
        this.cedula = cedula;
        this.telefono = telefono;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getCedula() {
        return cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void iniciarSesion() {
        sesionActiva = true;
    }

    public void cerrarSesion() {
        sesionActiva = false;
    }

    public boolean tieneSesionActiva() {
        return sesionActiva;
    }

    public void actualizarDatos(String nombre, String correo, String cedula, String telefono) {
        this.nombre = nombre;
        this.correo = correo;
        this.cedula = cedula;
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "ID: " + idPersona + " | Nombre: " + nombre + " | Correo: " + correo
            + " | Cédula: " + cedula + " | Teléfono: " + telefono;
    }
}