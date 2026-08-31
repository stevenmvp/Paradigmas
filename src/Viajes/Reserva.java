package Viajes;

import java.time.LocalDate;

public class Reserva {
    private final String codigoReserva;
    private final Usuario usuario;
    private final Destino destino;
    private final Hotel hotel;
    private final Actividad actividad;
    private final LocalDate fechaViaje;
    private EstadoReserva estado;

    public Reserva(String codigoReserva, Usuario usuario, Destino destino, Hotel hotel,
            Actividad actividad, LocalDate fechaViaje) {
        this.codigoReserva = codigoReserva;
        this.usuario = usuario;
        this.destino = destino;
        this.hotel = hotel;
        this.actividad = actividad;
        this.fechaViaje = fechaViaje;
        this.estado = EstadoReserva.PENDIENTE;
    }

    public void confirmarReserva() {
        if (estado != EstadoReserva.PENDIENTE) return;
        if (hotel != null && !hotel.reservarCupo()) {
            throw new IllegalStateException("No hay habitaciones disponibles.");
        }
        if (actividad != null && !actividad.reservarCupo()) {
            if (hotel != null) hotel.liberarCupo();
            throw new IllegalStateException("No hay cupos disponibles para la actividad.");
        }
        estado = EstadoReserva.CONFIRMADA;
    }
    public void cancelarReserva() {
        if (estado == EstadoReserva.CONFIRMADA) {
            if (hotel != null) hotel.liberarCupo();
            if (actividad != null) actividad.liberarCupo();
        }
        estado = EstadoReserva.CANCELADA;
    }

    public void restaurarEstado(EstadoReserva estado) { this.estado = estado; }

    public double calcularTotal(int noches) {
        double total = hotel == null ? 0 : hotel.calcularCostoTotal(noches);
        return total + (actividad == null ? 0 : actividad.getPrecio());
    }

    public String getCodigoReserva() { return codigoReserva; }
    public Usuario getUsuario() { return usuario; }
    public Destino getDestino() { return destino; }
    public Hotel getHotel() { return hotel; }
    public Actividad getActividad() { return actividad; }
    public LocalDate getFechaViaje() { return fechaViaje; }
    public EstadoReserva getEstado() { return estado; }
}