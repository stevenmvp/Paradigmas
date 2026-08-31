package Viajes;

public class Tour extends Actividad {
    private final String nombreGuia;
    private final String puntoEncuentro;

    public Tour(String id, String nombre, Destino destino, double precio, String horario, int cupos,
            String nombreGuia, String puntoEncuentro) {
        super(id, nombre, destino, precio, horario, cupos);
        this.nombreGuia = nombreGuia;
        this.puntoEncuentro = puntoEncuentro;
    }

    public String getNombreGuia() { return nombreGuia; }
    public String getPuntoEncuentro() { return puntoEncuentro; }
    @Override
    public String mostrarDetalles() { return "Tour guiado por " + nombreGuia + " desde " + puntoEncuentro; }
}