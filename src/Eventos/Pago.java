package Eventos;

public class Pago {
    private final int idPago;
    private final double monto;
    private final String fechaPago;
    private final String metodo;
    private String estadoPago;

    public Pago(int idPago, double monto, String fechaPago, String metodo) {
        this.idPago = idPago;
        this.monto = monto;
        this.fechaPago = fechaPago;
        this.metodo = metodo;
        this.estadoPago = "Pendiente";
    }

    public int getIdPago() {
        return idPago;
    }

    public double getMonto() {
        return monto;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public String getMetodo() {
        return metodo;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void procesarPago() {
        estadoPago = "Procesado";
    }

    public String generarRecibo() {
        return "Recibo de pago " + idPago + " | Monto: " + monto
                + " | Estado: " + estadoPago;
    }
}
