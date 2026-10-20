package EjeVehiculos.Vehiculos;

public abstract class Vehiculo {

    private String Marca;
    private String Modelo;
    private Double PrecioBase;

    public Vehiculo(String Marca, String Modelo, Double PrecioBase) {
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.PrecioBase = PrecioBase;
    }

    public String getMarca() {
        return Marca;
    }

    public String getModelo() {
        return Modelo;
    }
    public Double getPrecioBase() {
        return PrecioBase;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }
    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }
    public void setPrecioBase(Double PrecioBase) {

        this.PrecioBase = PrecioBase;
    }
    
    public Double costo(){
        return getPrecioBase();
    }

    public abstract void mostrarInformacion();
}
