package SistemaBiblioteca;

public class Usuario {

    private final String nombre;
    private int restriccionHasta = -1;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public boolean puedePrestar(SimularTiempo tiempo) {
        return restriccionHasta < 0 || tiempo.getDiaActual() > restriccionHasta;
    }

    public void restringirHasta(int dia) {
        restriccionHasta = dia;
    }

    public String getNombre() {
        return nombre;
    }

    public int getRestriccionHasta() {
        return restriccionHasta;
    }
}