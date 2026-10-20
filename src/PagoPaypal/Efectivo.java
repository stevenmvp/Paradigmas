package PagoPaypal;

public class Efectivo implements MetodoPago {

    private double monto;

    public Efectivo(double monto) {
        this.monto = monto;
    }


    @Override
    public void realizarPago() {
        System.out.println("pago en efectivo por: $" + monto);
        pagoProcessado();
    }


}
