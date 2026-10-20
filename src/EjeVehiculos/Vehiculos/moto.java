package EjeVehiculos.Vehiculos;


public class moto extends Vehiculo {
    private int cilindrada;
    private String Deportiva;

    public moto(String Marca, String Modelo, Double PrecioBase, int cilindrada, String Deportiva) {
        super(Marca, Modelo, PrecioBase);
        this.cilindrada = cilindrada;
        this.Deportiva = Deportiva;
    }

    public int getCilindrada() {
        return cilindrada;
    }
    
    public String getDeportiva() {
        return Deportiva;
    }
    public void setDeportiva(String Deportiva) {
        this.Deportiva = Deportiva;
    }


    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }

    @Override
    public Double costo() {
        if (Deportiva == "si") {
            return getPrecioBase() * 3;
        } else {
            return getPrecioBase() * 1.25;
        }
    }
        
        public void mostrarInformacion() {
        System.out.println("Marca: " + getMarca());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Precio Base: " + getPrecioBase());
    }



}
