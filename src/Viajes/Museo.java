package Viajes;

public class Museo extends Actividad {
    private final String tematica;
    private final String exposicionPrincipal;

    public Museo(String id, String nombre, Destino destino, double precio, String horario, int cupos,
            String tematica, String exposicionPrincipal) {
        super(id, nombre, destino, precio, horario, cupos);
        this.tematica = tematica;
        this.exposicionPrincipal = exposicionPrincipal;
    }

    public String getTematica() { return tematica; }
    public String getExposicionPrincipal() { return exposicionPrincipal; }
    @Override
    public String mostrarDetalles() { return "Museo: " + tematica + " | Exposición: " + exposicionPrincipal; }
}