package SistemaBiblioteca;

public class SimularTiempo {

    private int diaActual;

    public SimularTiempo() {
        diaActual = 0;
    }

    public void avanzarDias(int dias) {
        if (dias < 0) {
            throw new IllegalArgumentException("Los dias deben ser positivos.");
        }
        diaActual += dias;
    }

    public int getDiaActual() {
        return diaActual;
    }
}