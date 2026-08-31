package Viajes;

import java.util.LinkedList;
import java.util.Queue;

public abstract class Actividad implements IReservable {
    private final String idActividad;
    private final String nombre;
    private final Destino destino;
    private final double precio;
    private final String horario;
    private final int cuposTotales;
    private int cuposDisponibles;
    private final Queue<Usuario> colaDeEspera = new LinkedList<>();

    protected Actividad(String idActividad, String nombre, Destino destino, double precio,
            String horario, int cuposTotales) {
        this.idActividad = idActividad;
        this.nombre = nombre;
        this.destino = destino;
        this.precio = precio;
        this.horario = horario;
        this.cuposTotales = cuposTotales;
        this.cuposDisponibles = cuposTotales;
    }

    @Override
    public boolean verificarDisponibilidad() { return cuposDisponibles > 0; }

    @Override
    public boolean reservarCupo() {
        if (!verificarDisponibilidad()) return false;
        cuposDisponibles--;
        return true;
    }

    @Override
    public void liberarCupo() {
        if (cuposDisponibles < cuposTotales) cuposDisponibles++;
    }

    public boolean solicitarCupo(Usuario usuario) {
        if (reservarCupo()) return true;
        colaDeEspera.offer(usuario);
        return false;
    }

    public Usuario atenderListaEspera() {
        if (colaDeEspera.isEmpty()) return null;
        if (!reservarCupo()) return null;
        return colaDeEspera.poll();
    }

    public abstract String mostrarDetalles();

    public String getIdActividad() { return idActividad; }
    public String getNombre() { return nombre; }
    public Destino getDestino() { return destino; }
    public double getPrecio() { return precio; }
    public String getHorario() { return horario; }
    public int getCuposTotales() { return cuposTotales; }
    public int getCuposDisponibles() { return cuposDisponibles; }
    public void restaurarCuposDisponibles(int cuposDisponibles) {
        this.cuposDisponibles = Math.max(0, Math.min(cuposTotales, cuposDisponibles));
    }
    public Queue<Usuario> getColaDeEspera() { return new LinkedList<>(colaDeEspera); }

    @Override
    public String toString() { return idActividad + " | " + nombre + " | $" + precio; }
}