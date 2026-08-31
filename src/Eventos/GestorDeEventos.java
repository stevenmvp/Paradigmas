package Eventos;

import java.util.ArrayList;
import java.util.List;

public class GestorDeEventos {
    private final List<Evento> eventos = new ArrayList<>();
    private int siguienteId = 1;

    public Evento crearEvento(String nombre, String fecha, String lugar, int capacidad) {
        Evento evento = new Evento(siguienteId++, nombre, fecha, lugar, capacidad);
        eventos.add(evento);
        return evento;
    }

    public Evento registrarEvento(String nombre, String fecha, String lugar, int capacidad) {
        return crearEvento(nombre, fecha, lugar, capacidad);
    }

    public void listarEventos() {
        if (eventos.isEmpty()) {
            System.out.println("No hay eventos registrados.");
            return;
        }

        System.out.println("\n--- Eventos registrados ---");
        for (Evento evento : eventos) {
            System.out.println(evento);
        }
    }

    public Evento buscarEvento(int id) {
        for (Evento evento : eventos) {
            if (evento.getIdEvento() == id) {
                return evento;
            }
        }
        return null;
    }

    public boolean actualizarEvento(int id, String estado) {
        if (!estado.equalsIgnoreCase("Programado")
                && !estado.equalsIgnoreCase("Realizado")
                && !estado.equalsIgnoreCase("Cancelado")) {
            return false;
        }

        Evento evento = buscarEvento(id);
        if (evento == null) {
            return false;
        }
        evento.setEstado(normalizarEstado(estado));
        return true;
    }

    public boolean actualizarEstado(int id, String estado) {
        return actualizarEvento(id, estado);
    }

    public boolean cancelarEvento(int id) {
        return actualizarEvento(id, "Cancelado");
    }

    public boolean eliminarEvento(int id) {
        Evento evento = buscarEvento(id);
        return evento != null && eventos.remove(evento);
    }

    private String normalizarEstado(String estado) {
        return estado.substring(0, 1).toUpperCase() + estado.substring(1).toLowerCase();
    }
}
