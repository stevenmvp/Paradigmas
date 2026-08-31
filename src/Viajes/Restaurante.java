package Viajes;

public class Restaurante extends Actividad {
    private final String tipoComida;
    private final boolean requiereVestimenta;

    public Restaurante(String id, String nombre, Destino destino, double precio, String horario, int cupos,
            String tipoComida, boolean requiereVestimenta) {
        super(id, nombre, destino, precio, horario, cupos);
        this.tipoComida = tipoComida;
        this.requiereVestimenta = requiereVestimenta;
    }

    public String getTipoComida() { return tipoComida; }
    public boolean isRequiereVestimenta() { return requiereVestimenta; }
    @Override
    public String mostrarDetalles() { return "Restaurante de comida " + tipoComida; }
}