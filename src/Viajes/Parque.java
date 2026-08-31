package Viajes;

public class Parque extends Actividad {
    private final boolean esNatural;

    public Parque(String id, String nombre, Destino destino, double precio, String horario, int cupos,
            boolean esNatural) {
        super(id, nombre, destino, precio, horario, cupos);
        this.esNatural = esNatural;
    }

    public boolean isEsNatural() { return esNatural; }
    @Override
    public String mostrarDetalles() { return esNatural ? "Parque natural" : "Parque urbano"; }
}