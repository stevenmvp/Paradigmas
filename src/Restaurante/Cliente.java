package Restaurante;

public class Cliente implement Facturar, Mostrar, Ordenar {

    private String IdCliente;
    private String nombre;
    private double consumo;

    public Cliente(String IdCliente, String nombre, double consumo) {
        this.IdCliente = IdCliente;
        this.nombre = nombre;
        this.consumo = consumo;
    }

    @Override
    public void facturar() {
        System.out.println("Facturando al cliente: " + nombre + " con ID: " + IdCliente + " por un consumo de: $" + consumo);
    }

    @Override
    public void mostrarInformacion() {

}
