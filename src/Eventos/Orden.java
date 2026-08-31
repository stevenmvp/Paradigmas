package Eventos;

import java.util.ArrayList;
import java.util.List;

public class Orden {
    private final int idOrden;
    private final String fechaCreacion;
    private String estado;
    private double total;
    private final List<Evento> eventos = new ArrayList<>();
    private Pago pago;

    public Orden(int idOrden, String fechaCreacion) {
        this.idOrden = idOrden;
        this.fechaCreacion = fechaCreacion;
        this.estado = "Pendiente";
    }

    public int getIdOrden() {
        return idOrden;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getTotal() {
        return total;
    }

    public List<Evento> getEventos() {
        return new ArrayList<>(eventos);
    }

    public Pago getPago() {
        return pago;
    }

    public void solicitarEvento(Evento evento) {
        if (evento != null && !eventos.contains(evento)) {
            eventos.add(evento);
            calcularTotal();
        }
    }

    public double calcularTotal() {
        total = eventos.stream().mapToDouble(Evento::getPrecio).sum();
        return total;
    }

    public void cancelarOrden() {
        estado = "Cancelada";
    }

    public void asignarPago(Pago pago) {
        this.pago = pago;
    }
}
