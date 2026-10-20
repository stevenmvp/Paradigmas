package EjeVehiculos.MetodosVehiculo;

public class MetodosCarro extends MetodosVehi {

    
    @Override
    public void arrancar() {
        System.out.println("El carro ha arrancado.");
    }

    @Override
    public void apagar() {
        System.out.println("El carro se ha apagado.");
    }

    @Override
    public void encender() {
        System.out.println("El carro ha sido encendido.");
    }

    
}
