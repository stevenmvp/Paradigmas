package Viajes;

import java.util.Stack;

public class Usuario {
    private final String documento;
    private String nombre;
    private String correo;
    private String telefono;
    private final String contrasena;
    private final Rol rol;
    private final Stack<String> historialBusquedas = new Stack<>();

    public Usuario(String documento, String nombre, String correo, String telefono) {
        this(documento, nombre, correo, telefono, "cliente123", Rol.CLIENTE);
    }

    public Usuario(String documento, String nombre, String correo, String telefono,
            String contrasena, Rol rol) {
        this.documento = documento;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    public void registrarBusqueda(String busqueda) {
        historialBusquedas.push(busqueda);
    }

    public String obtenerUltimaBusqueda() {
        return historialBusquedas.isEmpty() ? null : historialBusquedas.peek();
    }

    public String getDocumento() { return documento; }
    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
    public String getTelefono() { return telefono; }
    public String getContrasena() { return contrasena; }
    public Rol getRol() { return rol; }
    public boolean autenticar(String contrasena) { return this.contrasena.equals(contrasena); }
    public Stack<String> getHistorialBusquedas() {
        Stack<String> copia = new Stack<>();
        copia.addAll(historialBusquedas);
        return copia;
    }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCorreo(String correo) { this.correo = correo; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    @Override
    public String toString() {
        return nombre + " (" + documento + ") - " + correo;
    }
}