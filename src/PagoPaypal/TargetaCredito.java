package PagoPaypal;

public class TargetaCredito implements MetodoPago {

    public String numero;

    public TargetaCredito(String numero) {
        this.numero = numero;
    }

    @Override
    public void realizarPago() {
        System.out.println("pago con targeta de credito numero: " + numero);
        pagoProcessado();
    }

}
