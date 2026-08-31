package Eventos;

import java.util.ArrayList;
import java.util.List;

public class GestionarUsuario {
    private final List<Persona> personas = new ArrayList<>();
    private final List<Usuario> usuarios = new ArrayList<>();
    private final List<Administrador> administradores = new ArrayList<>();
    private int siguienteId = 1;

    public GestionarUsuario() {
        administradores.add(new Administrador(siguienteId++, "Administrador principal",
            "admin@eventos.com", "0000000000", "0000000000", "admin", "admin123"));
    }

    public Persona registrarPersona(String nombre, String correo, String telefono) {
        Persona persona = new Persona(siguienteId++, nombre, correo, "", telefono);
        personas.add(persona);
        return persona;
    }

    public Administrador iniciarSesion(String usuario, String contrasena) {
        for (Administrador administrador : administradores) {
            if (administrador.getUsuario().equals(usuario) && administrador.autenticar(contrasena)) {
                return administrador;
            }
        }
        return null;
    }

    public void listarPersonas() {
        if (personas.isEmpty()) {
            System.out.println("No hay personas registradas.");
            return;
        }

        System.out.println("\n--- Personas registradas ---");
        for (Persona persona : personas) {
            System.out.println(persona);
        }
    }

    public Usuario registrarNuevoUsuario(int id, String nombre, String correo,
            String telefono, String direccion, String fechaDeRegistro) {
        Usuario usuario = new Usuario(id, nombre, correo, "", telefono, direccion, fechaDeRegistro);
        usuarios.add(usuario);
        return usuario;
    }

    public boolean eliminarUsuario(int id) {
        return usuarios.removeIf(usuario -> usuario.getIdPersona() == id);
    }

    public List<Usuario> listarUsuarios() {
        return new ArrayList<>(usuarios);
    }
}
