package Eventos;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
    private final int idCategoria;
    private final String nombre;
    private final String descripcion;
    private final List<Evento> eventos = new ArrayList<>();

    public Categoria(int idCategoria, String nombre, String descripcion) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void agregarEvento(Evento evento) {
        if (evento != null && !eventos.contains(evento)) {
            eventos.add(evento);
        }
    }

    public List<Evento> listarEventos() {
        return new ArrayList<>(eventos);
    }
}
