package EjeVehiculos.Vehiculos;


public class Carro extends Vehiculo {
    private int numeroPuertas;

    public Carro(String Marca, String Modelo, Double PrecioBase, int numeroPuertas) {
        super(Marca, Modelo, PrecioBase);
        this.numeroPuertas = numeroPuertas;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }

    @Override
    public Double costo() {
        if (numeroPuertas <= 4) {
            return getPrecioBase() * 1.25;
        } else if(numeroPuertas > 4 && numeroPuertas <= 6) {
            return getPrecioBase() * 3;
        }else{
            return getPrecioBase() * 4;
        }
    }

        @Override 
        public void mostrarInformacion() {
        System.out.println("Marca: " + getMarca());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Precio Base: " + getPrecioBase());
    }

}
