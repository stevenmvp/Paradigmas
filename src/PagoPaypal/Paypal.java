package PagoPaypal;

public class Paypal implements MetodoPago {

    private String email;

    public Paypal(String email) {
        this.email = email  ;
    }

    @Override
    public void realizarPago() {
        System.out.println("pago con Paypal desde la cuenta: " + email);
        pagoProcessado();
    }

}
