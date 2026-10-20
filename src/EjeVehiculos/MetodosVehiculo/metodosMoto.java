package EjeVehiculos.MetodosVehiculo;

public class metodosMoto extends MetodosVehi {
    @Override
    public void arrancar() {
        System.out.println("La moto ha arrancado.");
    }

    @Override
    public void apagar() {
        System.out.println("La moto se ha apagado.");
    }

    @Override
    public void encender() {
        System.out.println("La moto ha sido encendida.");
    }
}
