package Eventos;

public class Evento {
    private final int idEvento;
    private final String titulo;
    private final String fechaHora;
    private final String ubicacion;
    private final int capacidadMaxima;
    private final double precio;
    private String estado;

    public Evento(int idEvento, String titulo, String fechaHora, String ubicacion, int capacidadMaxima) {
        this(idEvento, titulo, fechaHora, ubicacion, capacidadMaxima, 0);
    }

    public Evento(int idEvento, String titulo, String fechaHora, String ubicacion,
            int capacidadMaxima, double precio) {
        this.idEvento = idEvento;
        this.titulo = titulo;
        this.fechaHora = fechaHora;
        this.ubicacion = ubicacion;
        this.capacidadMaxima = capacidadMaxima;
        this.precio = precio;
        this.estado = "Programado";
    }

    public int getIdEvento() {
        return idEvento;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public double getPrecio() {
        return precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void agregarEvento() {
        estado = "Programado";
    }

    public String listarEvento() {
        return toString();
    }

    @Override
    public String toString() {
        return "ID: " + idEvento + " | " + titulo + " | Fecha: " + fechaHora
            + " | Lugar: " + ubicacion + " | Capacidad: " + capacidadMaxima
                + " | Estado: " + estado;
    }
}