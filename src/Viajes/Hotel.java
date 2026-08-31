package Viajes;

public class Hotel implements IReservable {
    private final String codigoHotel;
    private final String nombre;
    private final Destino destino;
    private final String tipoHabitacion;
    private final double precioNoche;
    private int habitacionesDisponibles;

    public Hotel(String codigoHotel, String nombre, Destino destino, String tipoHabitacion,
            double precioNoche, int habitacionesDisponibles) {
        this.codigoHotel = codigoHotel;
        this.nombre = nombre;
        this.destino = destino;
        this.tipoHabitacion = tipoHabitacion;
        this.precioNoche = precioNoche;
        this.habitacionesDisponibles = habitacionesDisponibles;
    }

    @Override
    public boolean verificarDisponibilidad() { return habitacionesDisponibles > 0; }

    @Override
    public boolean reservarCupo() {
        if (!verificarDisponibilidad()) return false;
        habitacionesDisponibles--;
        return true;
    }

    @Override
    public void liberarCupo() { habitacionesDisponibles++; }

    public double calcularCostoTotal(int noches) { return precioNoche * noches; }
    public String getCodigoHotel() { return codigoHotel; }
    public String getNombre() { return nombre; }
    public Destino getDestino() { return destino; }
    public String getTipoHabitacion() { return tipoHabitacion; }
    public double getPrecioNoche() { return precioNoche; }
    public int getHabitacionesDisponibles() { return habitacionesDisponibles; }
    public void restaurarHabitacionesDisponibles(int habitacionesDisponibles) { this.habitacionesDisponibles = Math.max(0, habitacionesDisponibles); }

    @Override
    public String toString() { return codigoHotel + " | " + nombre + " | " + destino.getCiudad(); }
}