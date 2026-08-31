package Viajes;

public class Excursion extends Actividad {
    private final String dificultad;
    private final String equipoNecesario;

    public Excursion(String id, String nombre, Destino destino, double precio, String horario, int cupos,
            String dificultad, String equipoNecesario) {
        super(id, nombre, destino, precio, horario, cupos);
        this.dificultad = dificultad;
        this.equipoNecesario = equipoNecesario;
    }

    public String getDificultad() { return dificultad; }
    public String getEquipoNecesario() { return equipoNecesario; }
    @Override
    public String mostrarDetalles() { return "Excursión de dificultad " + dificultad + " | Equipo: " + equipoNecesario; }
}