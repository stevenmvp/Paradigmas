package Eventos;

public class Administrador extends Persona {
    private final String usuario;
    private String contrasena;
    private int nivelAcceso;

    public Administrador(int id, String nombre, String correo, String cedula, String telefono,
            String usuario, String contrasena) {
        super(id, nombre, correo, cedula, telefono);
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nivelAcceso = 1;
    }

    public String getUsuario() {
        return usuario;
    }

    public boolean autenticar(String contrasena) {
        return this.contrasena.equals(contrasena);
    }

    public int getNivelAcceso() {
        return nivelAcceso;
    }

    public void setNivelAcceso(int nivelAcceso) {
        this.nivelAcceso = nivelAcceso;
    }

    public String generarReporte() {
        return "Reporte generado por " + getNombre();
    }

    public boolean cambiarContrasena(String contrasenaActual, String nuevaContrasena) {
        if (!autenticar(contrasenaActual) || nuevaContrasena == null || nuevaContrasena.isBlank()) {
            return false;
        }

        contrasena = nuevaContrasena;
        return true;
    }

    @Override
    public String toString() {
        return "Administrador | " + super.toString() + " | Usuario: " + usuario;
    }
}