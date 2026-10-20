package PagoPaypal;

public class Main {

    public static void main(String[] args) {
        MetodoPago metodo1 = new Paypal("user@example.com");
        MetodoPago metodo2 = new Efectivo(100.0);
        MetodoPago metodo3 = new TargetaCredito("1234-5678-9012-3456");

        metodo1.realizarPago();
        metodo2.realizarPago();
        metodo3.realizarPago();

}
