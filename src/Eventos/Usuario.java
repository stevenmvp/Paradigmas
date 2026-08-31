package Eventos;

import java.util.ArrayList;
import java.util.List;

public class Usuario extends Persona {
    private final String direccion;
    private final String fechaDeRegistro;
    private final List<Orden> ordenes = new ArrayList<>();

    public Usuario(int id, String nombre, String correo, String cedula, String telefono,
            String direccion, String fechaDeRegistro) {
        super(id, nombre, correo, cedula, telefono);
        this.direccion = direccion;
        this.fechaDeRegistro = fechaDeRegistro;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getFechaDeRegistro() {
        return fechaDeRegistro;
    }

    public void realizarOrden(Orden orden) {
        if (orden != null && !ordenes.contains(orden)) {
            ordenes.add(orden);
        }
    }

    public List<Orden> verHistorialDeOrden() {
        return new ArrayList<>(ordenes);
    }
}
