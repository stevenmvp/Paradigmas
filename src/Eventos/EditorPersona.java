package Eventos;

public class EditorPersona {
    public void actualizarDatos(Persona persona, String nombre, String correo,
            String cedula, String telefono) {
        if (persona != null) {
            persona.actualizarDatos(nombre, correo, cedula, telefono);
        }
    }

    public boolean cambiarContrasena(Administrador administrador, String contrasenaActual,
            String nuevaContrasena) {
        if (administrador == null || nuevaContrasena == null || nuevaContrasena.isBlank()) {
            return false;
        }

        return administrador.cambiarContrasena(contrasenaActual, nuevaContrasena);
    }
}