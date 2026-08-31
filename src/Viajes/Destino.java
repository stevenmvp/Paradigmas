package Viajes;

public class Destino {
    private final String codigoDestino;
    private final String ciudad;
    private final String pais;
    private double precioAproximado;
    private String tipoDestino;
    private boolean disponible;

    public Destino(String codigoDestino, String ciudad, String pais, double precioAproximado,
            String tipoDestino, boolean disponible) {
        this.codigoDestino = codigoDestino;
        this.ciudad = ciudad;
        this.pais = pais;
        this.precioAproximado = precioAproximado;
        this.tipoDestino = tipoDestino;
        this.disponible = disponible;
    }

    public String getCodigoDestino() { return codigoDestino; }
    public String getCiudad() { return ciudad; }
    public String getPais() { return pais; }
    public double getPrecioAproximado() { return precioAproximado; }
    public String getTipoDestino() { return tipoDestino; }
    public boolean isDisponible() { return disponible; }
    public void setPrecioAproximado(double precioAproximado) { this.precioAproximado = precioAproximado; }
    public void setTipoDestino(String tipoDestino) { this.tipoDestino = tipoDestino; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    @Override
    public String toString() {
        return codigoDestino + " | " + ciudad + ", " + pais + " | $" + precioAproximado
                + " | " + tipoDestino;
    }
}